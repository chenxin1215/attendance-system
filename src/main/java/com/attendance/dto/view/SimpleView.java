package com.attendance.dto.view;

public class SimpleView extends BaseView<Object> {

    @Override
    public void success(Object object) {
        this.setRspCode(SUCCESS);
        this.setRspData(object);
    }

}
