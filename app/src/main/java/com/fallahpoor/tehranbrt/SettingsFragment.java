/*
    Copyright (C) 2016 Masood Fallahpoor

    This file is part of Tehran BRT.

    Tehran BRT is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Tehran BRT is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Tehran BRT. If not, see <http://www.gnu.org/licenses/>.
 */

package com.fallahpoor.tehranbrt;

import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.akexorcist.localizationactivity.LocalizationActivity;

/**
 * SettingsFragment displays the settings of the app.
 *
 * @author Masood Fallahpoor
 */
public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        addPreferencesFromResource(R.xml.settings);

        findPreference("language").setOnPreferenceChangeListener(
                new LanguagePreferenceChangeListener());

    }

    private class LanguagePreferenceChangeListener implements
            Preference.OnPreferenceChangeListener {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {

            ListPreference languagePreference;
            String language;
            int index;

            languagePreference = (ListPreference) preference;
            index = languagePreference.findIndexOfValue(newValue.toString());

            if (index != -1) {

                language = languagePreference.getEntryValues()[index].toString();

                ((LocalizationActivity) getActivity()).setLanguage(language);

            }

            return true;

        } // end of method onPreferenceChange

    } // end of inner class LanguagePreferenceChangeListener

} // end of class SettingsFragment
