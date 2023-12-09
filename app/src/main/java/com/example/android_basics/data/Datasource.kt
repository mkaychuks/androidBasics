package com.example.android_basics.data

import com.example.android_basics.R
import com.example.android_basics.model.Affirmation

class Datasource {

    fun loadAffirmations(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(stringResourceId = R.string.affirmation1, imageResourceId = R.drawable.phs_7672_copy),
            Affirmation(stringResourceId = R.string.affirmation2, imageResourceId = R.drawable.phs_7694_copy),
            Affirmation(stringResourceId = R.string.affirmation3, imageResourceId = R.drawable.personstatement),
            Affirmation(stringResourceId = R.string.affirmation4, imageResourceId = R.drawable.phs_7710_copy),
            Affirmation(stringResourceId = R.string.affirmation5, imageResourceId = R.drawable.phs_7715_copy),
            Affirmation(stringResourceId = R.string.affirmation6, imageResourceId = R.drawable.sample5),
        )
    }
}