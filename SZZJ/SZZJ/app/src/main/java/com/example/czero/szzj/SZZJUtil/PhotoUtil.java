package com.example.czero.szzj.SZZJUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;



/**
 * 图片工具类
 */
public class PhotoUtil {

    /**
     * 图片缓存文件夹路径
     */
    public static String ImageCacheFilePath = Environment.getExternalStorageDirectory() + "/bczp/" + "images/";


    public static String getBitmapThumbnailPath(String path) {
        Bitmap mBitmap ;
        File mFile=new File(path);
        int rotation = getExifOrientation(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        long initSize = mFile.length() / 1024;   //图片是否大于600kb,大于需要压缩

        if (initSize < 600) {
            if (rotation != 0){
                mBitmap = BitmapFactory.decodeFile(path); // 实例化Bitmap
                mBitmap = rotateBitmap(mBitmap, rotation);
                return saveToLocal(mBitmap);
            }else {//返回原地址
                return path;
            }
        } else{
            String fileName = UUID.randomUUID().toString() + ".jpg";
            String filePath = ImageCacheFilePath + fileName;
            File file = new File(filePath);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(path, options);
                int mSampleSize =  calculateInSampleSize(options, 1920, 1080);
                if (mSampleSize > 1) {
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = mSampleSize;
                    mBitmap = BitmapFactory.decodeFile(path, options);
                }else {
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = 1;
                    mBitmap = BitmapFactory.decodeFile(path, options);
                }
                int quality =100;
                if (rotation != 0)
                    mBitmap = rotateBitmap(mBitmap, rotation);
                mBitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
                while ( baos.toByteArray().length / 1024>600) {  //循环判断如果压缩后图片是否大于600kb,大于继续压缩
                    baos.reset();//重置baos即清空baos
                    quality -= 10;//每次都减少10
                    mBitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);//这里压缩options%，把压缩后的数据存放到baos中
                }
                if (!file.getParentFile().exists())
                    file.getParentFile().mkdirs();
                FileOutputStream fo = new FileOutputStream(file);
                fo.write(baos.toByteArray());
                fo.flush();
                fo.close();
            } catch (Exception e) {
            } catch (OutOfMemoryError e) { // 捕获OutOfMemoryError，避免直接崩溃
            }
            return filePath;
        }
    }
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth) {
            if(width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }

            float totalPixels = (float)(width * height);

            for(float totalReqPixelsCap = (float)(reqWidth * reqHeight * 2); totalPixels / (float)(inSampleSize * inSampleSize) > totalReqPixelsCap; ++inSampleSize) {
                ;
            }
        }

        return inSampleSize;
    }



    /**
     * 获取拍摄角度
     */
    public static int getExifOrientation(String path) {
        String img_path = path;
        System.out.println("图片位置" + img_path);
        int degree = 0;
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(img_path);
        } catch (IOException e) {
        }
        if (exif != null) {
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);
            if (orientation != -1) { // We only recognize a subset of orientation tag values.
                switch (orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        degree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        degree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        degree = 270;
                        break;
                }
            }
        }
        return degree;
    }


    /**
     * 旋转图像
     */
    public static Bitmap rotateBitmap(Bitmap bmp, int degrees) {
        if (degrees != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees);
            return Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
        }
        return bmp;
    }


    /**
     * 旋转图片
     */

    private static Bitmap toRotationBitmap(Bitmap bitmap, final int rotation) {
        if (rotation == 0)
            return bitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate(rotation);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        float scale = 1f;// 防止内存溢出，先添加一个基本判断，根据测试情况更改
        while (height > 2200) {
            height /= 2;
            width /= 2;
            scale *= 0.5f;
        }
        matrix.postScale(scale, scale);
        int neHeight = height;
        int neWidth = width;
        if (rotation == 90 || rotation == 270) {
            neHeight = width;
            neWidth = height;
        }
        Bitmap canvasBitmap = Bitmap.createBitmap(neWidth, neHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(canvasBitmap);
        float transX = height;
        float transY = 0;
        if (rotation == 90) {
            transX = height;
            transY = 0;
        } else if (rotation == 180) {
            transX = width;
            transY = height;
        } else if (rotation == 270) {
            transX = 0;
            transY = width;
        } else {
            transX = 0;
            transY = 0;
        }
        matrix.postTranslate(transX, transY);
        canvas.drawBitmap(bitmap, matrix, new Paint());
        if (bitmap != null) {
            bitmap.recycle();
            bitmap = null;
            System.gc();
        }
        return canvasBitmap;
    }


    public static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        int initialSize = computeInitialSampleSize(options, minSideLength, maxNumOfPixels);
        int roundedSize;
        if (initialSize <= 8) {
            roundedSize = 1;
            while (roundedSize < initialSize) {
                roundedSize <<= 1;
            }
        } else {
            roundedSize = (initialSize + 7) / 8 * 8;
        }
        return roundedSize;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels) {
        double w = options.outWidth;
        double h = options.outHeight;
        int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math.sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(Math.floor(w / minSideLength), Math.floor(h / minSideLength));
        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }
        if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
            return 1;
        } else if (minSideLength == -1) {
            return lowerBound;
        } else {
            return upperBound;
        }
    }


    /**
     * 保存图片到本地(JPG)
     *
     * @return 图片路径
     */
    public static String saveToLocal(Bitmap bm) {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return null;
        }
        FileOutputStream fileOutputStream = null;
        File file = new File(ImageCacheFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = UUID.randomUUID().toString() + ".jpg";
        String filePath = ImageCacheFilePath + fileName;
        File f = new File(filePath);
        if (!f.exists()) {
            try {
                f.createNewFile();
                fileOutputStream = new FileOutputStream(filePath);
                if (bm != null && fileOutputStream != null) {
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                } else {
                    f.delete();
                }
            } catch (IOException e) {
                return null;
            } finally {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    return null;
                }
            }
        }
        return filePath;
    }


}
