/*
 * Copyright 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2raw;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


//TEST
/**
 * Activity displaying a fragment that implements RAW photo captures.
 */
public class CameraActivity extends Activity {
    private static String sub_ID;
    private static String hand;
    private static String spoof;
    private static String spoof_type;
    private static String session_ID;
    private static String trial_Num;
    private static String phone_Num;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.naming);

        EditText usr_sub_id = findViewById(R.id.usrSubId);
        usr_sub_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sub_ID = editable.toString();
            }
        });

        // Left right hand
        RadioGroup handGroup = (RadioGroup) findViewById(R.id.leftRightGroup);
        final RadioButton leftRadio = (RadioButton) findViewById(R.id.leftButton);
        RadioButton rightRadio = (RadioButton) findViewById(R.id.rightButton);

        handGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (leftRadio.isChecked()){
                    hand = "L";
                }
                else{
                    hand = "R";
                }
            }
        });

        // Spoof / Live
        RadioGroup spoofGroup = (RadioGroup) findViewById(R.id.liveSpoofGroup);
        final RadioButton liveButton = (RadioButton) findViewById(R.id.live);

        spoofGroup.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (liveButton.isChecked()){
                    spoof = "Live";
                }
                else{
                    spoof = "Spoof";
                }
            }
        }));

        // Spoof Type
        EditText usr_spoof_type = findViewById(R.id.usrSpoofType);
        usr_spoof_type.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                spoof_type = editable.toString();
            }
        });

        // Session ID
        EditText usr_session_id = findViewById(R.id.usrSessionID);
        usr_session_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                session_ID = editable.toString();
            }
        });

        // Trial Number
        EditText usr_trial_num = findViewById(R.id.usrTrialNum);
        usr_trial_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                trial_Num = editable.toString();
            }
        });

        // Phone Number (Which phone 1,2,3,4 of the type)
        EditText usr_phone_num = findViewById(R.id.usrPhoneNum);
        usr_phone_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                phone_Num = editable.toString();
            }
        });

        // Go to camera App
        Button next_button = findViewById(R.id.nextButton);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spoof == "Live"){
                    spoof_type = null;
                }
                if(sub_ID != null && hand != null && spoof != null && session_ID != null && session_ID != null && trial_Num != null && phone_Num != null && (spoof == "Live" || spoof_type != null) ){
                    setContentView(R.layout.activity_camera);
                    if (null == savedInstanceState) {
                        getFragmentManager().beginTransaction()
                                .replace(R.id.container, Camera2RawFragment.newInstance())
                                .commit();
                    }
                }

            }
        });

    }

    // Getters and Setters
    public static String getSub_ID(){
        return sub_ID;
    }

    public static String getHand(){
        return hand;
    }

    public static String getSpoof(){
        return spoof;
    }

    public static String getSpoof_type(){
        return spoof_type;
    }

    public static String getSession_ID(){
        return session_ID;
    }

    public static String getTrial_Num(){
        return trial_Num;
    }

    public static String getPhone_Num(){
        return phone_Num;
    }


}
