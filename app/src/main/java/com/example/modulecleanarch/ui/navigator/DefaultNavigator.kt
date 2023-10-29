package com.example.modulecleanarch.ui.navigator

import com.example.common_utils.Activities
import com.example.common_utils.Navigator
import com.example.module_ui.GoToModuleActivity
import com.example.search_ui.GoToSearchActivity

/**
 * @author : Mingaleev D
 * @data : 29.10.2023
 */

class DefaultNavigator : Navigator.Provider {

   override fun getActivities(activities: Activities): Navigator {
      return when (activities) {
         Activities.ModuleActivity -> {
            GoToModuleActivity
         }
         Activities.SearchActivity -> {
            GoToSearchActivity
         }
      }
   }


}