/*
 * Copyright (c) 1998-2012 TENCENT Inc. All Rights Reserved.
 * 
 * FileName: DeviceManager.java
 * 
 * Description: 璁惧绠＄悊绫绘枃浠�
 * 
 * History:
 * 1.0	devilxie	2012-09-05	Create
 */

package com.app.framework.util;

import java.util.Locale;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.WindowManager;

/**
 * 璁惧绠＄悊绫伙紝涓昏鎻愪緵璁惧鐩稿叧鍙傛暟鐨勫垽瀹氾紝浠ュ強鍚勭娴嬮噺鍗曚綅鐨勮浆鎹�
 * @author devilxie
 * @version 1.0
 *
 */
public final class DeviceManager
{
	/**
	 * 鍒ゆ柇鏄惁涓轰腑鏂囩幆澧�
	 * @param context 涓婁笅鏂�
	 * @return 杩斿洖鍒ゆ柇缁撴灉
	 */
	public static boolean isChinese(Context context)
	{
		Locale locale = context.getResources().getConfiguration().locale;
		return locale.toString().equals("zh_CN");
	}

	/**
	 * 鍒ゆ柇鏄惁妯″睆
	 * @param context 涓婁笅鏂�
	 * @return 杩斿洖鍒ゆ柇缁撴灉
	 */
	public static boolean isScreenPortrait(Context context)
	{
		return context.getResources().getConfiguration().orientation == 1;
	}

	/**
	 * 灏嗛渶瑕佺殑瀛椾綋澶x杞寲涓簊p
	 * @param size
	 * @return
	 */
	public static float px2sp(Context context, float size) {
	    final float scale = context.getResources().getDisplayMetrics().density;  
	    if (size <= 0) {
            size = 15;
        }       
        float realSize = (float) (size * (scale - 0.1));
        return realSize;
	}
	
	/** 
     * 鏍规嵁鎵嬫満鐨勫垎杈ㄧ巼浠�dp 鐨勫崟浣�杞垚涓�px(鍍忕礌) 
     */  
    public static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 鏍规嵁鎵嬫満鐨勫垎杈ㄧ巼浠�px(鍍忕礌) 鐨勫崟浣�杞垚涓�dp 
     */  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }
	
	/**
	 * 灏嗛渶瑕佺殑瀛椾綋澶p杞寲涓�
	 * @param size
	 * @return
	 */
	public static float sp2px(Context context, float size) {
	    final float scale = context.getResources().getDisplayMetrics().density;  
	    if (size <= 0) {
	        size = 15;
	    }	    
	    float realSize = (float) (size / (scale - 0.1));
	    return realSize;
	}	
	
	/**
	 * 鑾峰彇Dimen涓殑澶у皬
	 */
	public static int getDimens (Context context, int resid)
	{
		return context.getResources().getDimensionPixelSize(resid);
	}
	
	public static String getString (Context context, int resid)
	{
		return context.getResources().getString(resid);
	}
	
	public static Drawable getDrawable (Context context, int resid)
	{
		return context.getResources().getDrawable(resid);
	}
	
	public static int getColor (Context context, int resid)
	{
		return context.getResources().getColor(resid);
	}

	public static ColorStateList getColorStateList (Context context, int resid)
	{
		return context.getResources().getColorStateList(resid);
	}
	
	/**
	 * 获取显示密度
	 */
	public static float getScreenDensity (Context context)
	{
		return context.getResources().getDisplayMetrics().density;
	}
	
	/**
	 * 获取显示宽度
	 */
	public static float getScreenWidth (Context context)
	{
		return context.getResources().getDisplayMetrics().widthPixels;
	}	
	
	/**
	 * 获取显示高度
	 */
	public static float getScreenHeight (Context context)
	{
		return context.getResources().getDisplayMetrics().heightPixels;
	}
	
	/**
	 * 获取屏幕宽度
	 * @param context
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getDisplayMetricsWith(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		
		if (AndroidNewApi.IsSDKLevelAbove(13)) {
			Point sizePoint = new Point();
			wm.getDefaultDisplay().getSize(sizePoint);
			return sizePoint.x;
		}
		else {
			return wm.getDefaultDisplay().getWidth();
					
		}
	}
	
	/**
	 * 获取屏幕高度
	 * @param mContext
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getDisplayMetricsHeight(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		
		if (AndroidNewApi.IsSDKLevelAbove(13)) {
			Point sizePoint = new Point();
			wm.getDefaultDisplay().getSize(sizePoint);
			return sizePoint.y;
		}
		else {
			return wm.getDefaultDisplay().getHeight();
					
		}
		
	}
}
