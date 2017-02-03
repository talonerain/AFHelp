package com.lsy.app.help;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by canfly on 2016/5/2.
 */
public class SendFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.send, container, false);
        Button btnSendMessage = (Button)view.findViewById(R.id.btn_send_message);
        btnSendMessage.setOnClickListener(this);
        btnSendMessage.getBackground().setAlpha(150);   //设置透明度
        Button btnSetMessage = (Button)view.findViewById(R.id.btn_set_message);
        btnSetMessage.setOnClickListener(this);
        Button btnMark = (Button)view.findViewById(R.id.btn_mark);
        btnMark.setOnClickListener(this);
        Button btnShare = (Button)view.findViewById(R.id.btn_share);
        btnShare.setOnClickListener(this);
        Button btnGuide = (Button)view.findViewById(R.id.btn_instruction);
        btnGuide.setOnClickListener(this);
        return view;
    }

    public interface SendFraInterface{
        void sendOnClick();
        void setOnClick();
        void markOnClick();
        void shareOnClick();
        void guideOnClick();
    }

    @Override
    public void onClick(View view) {
        if(getActivity() instanceof SendFraInterface)
        {
            switch (view.getId()){
                case R.id.btn_send_message:
                    ((SendFraInterface) getActivity()).sendOnClick();
                    break;
                case R.id.btn_set_message:
                    ((SendFraInterface) getActivity()).setOnClick();
                    break;
                case R.id.btn_mark:
                    ((SendFraInterface) getActivity()).markOnClick();
                    break;
                case R.id.btn_share:
                    ((SendFraInterface) getActivity()).shareOnClick();
                    break;
                case R.id.btn_instruction:
                    ((SendFraInterface) getActivity()).guideOnClick();
                    break;
                default:
                    break;
            }
        }
    }
}
