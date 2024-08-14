package org.danu.benchod.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SimpleNavController(initialScreen: Screen) {

    //val currentscreen
    private val _currentScreen = MutableStateFlow(initialScreen)
    val currentscreen =_currentScreen.asStateFlow()


    //val backstack
    private val backstack:MutableList<Screen> = mutableListOf()

        //navigate To
    fun navigateTo(screen: Screen){
        backstack.add(_currentScreen.value)
            _currentScreen.update { screen }
          //  _currentScreen.value= screen
    }

    //navigateback
        fun navigateBack(){
            if(backstack.isNotEmpty()){
                _currentScreen.update { backstack.last() }
                backstack.removeLast()
            }
        }


}