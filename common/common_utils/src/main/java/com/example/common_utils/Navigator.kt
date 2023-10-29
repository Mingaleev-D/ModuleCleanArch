package com.example.common_utils

import android.app.Activity

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

interface Navigator {

   fun navigate(activity: Activity)

   interface Provider {

      fun getActivities(activities: Activities): Navigator
   }
}