/**
 * Copyright 2013 Joan Zapata
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.czero.szzj.SZZJData;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static com.example.czero.szzj.SZZJData.LostFoundBaseAdapterHelper.get;


public abstract class LostFoundQuickAdapter<T> extends LostFoundBaseQuickAdapter<T, LostFoundBaseAdapterHelper> {


    public LostFoundQuickAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public LostFoundQuickAdapter(Context context, int layoutResId, List<T> data) {
        super(context,layoutResId,data);
    }

	protected LostFoundBaseAdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent) {
		return get(context, convertView, parent, layoutResId, position);
	}

}
