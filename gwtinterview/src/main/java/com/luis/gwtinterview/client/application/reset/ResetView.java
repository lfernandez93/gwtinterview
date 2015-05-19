package com.luis.gwtinterview.client.application.reset;

import javax.inject.Inject;

import com.google.appengine.api.memcache.MemcacheServicePb.MemcacheIncrementRequest.Direction;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewImpl;
import com.luis.gwtinterview.client.utils.Configuration;

class ResetView extends ViewImpl implements ResetPresenter.MyView {
    interface Binder extends UiBinder<Widget, ResetView> {
    }


    @UiField
    FormPanel form;
    
    private DatePicker datePicker;
    private TextBox textBox;
    private Button resetBtn;
    @Inject
    ResetView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initializeUI();
    }
    
    private void initializeUI(){
     datePicker = new DatePicker();	
     textBox = new TextBox();
     resetBtn = new ResetButton();
     resetBtn.setText("Reset");
     Label lbl = new Label("Reset Form");
     FlexTable flexTable = new FlexTable();
     
     flexTable.setWidget(0, 0, lbl);
    // flexTable.getFlexCellFormatter().setRowSpan(0, 0, 2);
     
     flexTable.setWidget(1, 0, new Label("Name"));
     flexTable.setWidget(1, 1, textBox);
     
     flexTable.setWidget(2, 0, new Label("Started"));
     flexTable.setWidget(2, 1, datePicker);
     
     flexTable.setWidget(3, 1, resetBtn);
     
     form.add(flexTable);
    }

	@Override
	public Button getResetButton() {
		// TODO Auto-generated method stub
		return resetBtn;
	}

	@Override
	public DatePicker getDatePicker() {
		// TODO Auto-generated method stub
		return datePicker;
	}

	@Override
	public TextBox getTextBox() {
		// TODO Auto-generated method stub
		return textBox;
	}


}