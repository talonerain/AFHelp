package com.lsy.app.help;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by canfly on 2016/5/2.
 */
public class MessageFragment extends DialogFragment implements View.OnClickListener, DialogInterface.OnKeyListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.printLog("MessageFragment onCreate被调用");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Util.printLog("MessageFragment onCreateView被调用");
        View view = inflater.inflate(R.layout.message, container, false);
        ImageButton btnClose = (ImageButton)view.findViewById(R.id.btn_msg_close);
        btnClose.setOnClickListener(this);
        Button btnCommit = (Button)view.findViewById(R.id.btn_commit);
        btnCommit.setOnClickListener(this);
        ImageView imagePhone1 = (ImageView)view.findViewById(R.id.image_phone1);
        imagePhone1.setOnClickListener(this);
        ImageView imagePhone2 = (ImageView)view.findViewById(R.id.image_phone2);
        imagePhone2.setOnClickListener(this);
        EditText phone1 = (EditText)view.findViewById(R.id.edit_phone1);
        EditText phone2 = (EditText)view.findViewById(R.id.edit_phone2);
        EditText message = (EditText)view.findViewById(R.id.message_input);
        if(getArguments().getBoolean("isHaveSetting")){
            Util.printLog("即将获取已设置内容");
            btnCommit.setText(getResources().getString(R.string.btn_commit_modify));
            phone1.setText(getArguments().getString("phone1Get", ""));
            phone2.setText(getArguments().getString("phone2Get", ""));
            message.setText(getArguments().getString("messageGet", ""));
            phone1.setEnabled(false);
            phone2.setEnabled(false);
            message.setEnabled(false);
            phone1.setHint("");
            phone2.setHint("");
            message.setBackgroundColor(getResources().getColor(R.color.edit_message));
            imagePhone1.setEnabled(false);
            imagePhone2.setEnabled(false);
        }else {
            Util.printLog("不会获取已设置内容");
            btnCommit.setText(getResources().getString(R.string.btn_commit_sure));
            phone1.setText("");
            phone2.setText("");
            message.setText("");
            phone1.setEnabled(true);
            phone2.setEnabled(true);
            message.setEnabled(true);
            message.setText("我现在遇到危险，无法拨打电话，快来救我");
            imagePhone1.setEnabled(true);
            imagePhone2.setEnabled(true);
        }
        this.getDialog().setOnKeyListener(this);
        return view;
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if(getActivity() instanceof MsgFrgOnclick && keyCode == KeyEvent.KEYCODE_BACK){
            ((MsgFrgOnclick) getActivity()).msgBackOnClick();
            return true;
        }else {
            return false;
        }
    }

    public interface MsgFrgOnclick{
        void msgCloseOnClick();
        void phoneList1OnClick();
        void phoneList2OnClick();
        void commitOnClick();
        void msgBackOnClick();
    }

    @Override
    public void onClick(View v) {
        if(getActivity() instanceof MsgFrgOnclick)
        {
            switch (v.getId()) {
                case R.id.btn_msg_close:
                    ((MsgFrgOnclick) getActivity()).msgCloseOnClick();
                    break;
                case R.id.btn_commit:
                    ((MsgFrgOnclick) getActivity()).commitOnClick();
                    break;
                case R.id.image_phone1:
                    ((MsgFrgOnclick) getActivity()).phoneList1OnClick();
                    break;
                case R.id.image_phone2:
                    ((MsgFrgOnclick) getActivity()).phoneList2OnClick();
                    break;
                default:
                    break;
            }
        }
    }
}
