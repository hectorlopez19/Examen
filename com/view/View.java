package com.view;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame {
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JPanel infoPanel;
    private JPanel buttonsPanel;
    private JTextField txtSearch;
    private JLabel labelName;
    private JTextField txtName;
    private JLabel labelLocation;
    private JTextField txtLocation;
    private JLabel labelAtractions;
    private JTextField txtAtractions;
    private JLabel labelCost;
    private JTextField txtCost;
    private JLabel labelCapacity;
    private JTextField txtCapacity;
    private JLabel labelStars;
    private JTextField txtStars;
    private JButton btnSearch;
    public JButton btnRegister;
    private JButton btnClean;
    private JButton btnDelete;
    private JLabel labelFull;
    private JLabel labelDeleted;
    private JLabel labelAlert;

    public View(String title) {
        super(title);

        setContentPane(mainPanel);

        btnSearch.setEnabled(false);
        btnRegister.setEnabled(false);
        btnDelete.setEnabled(false);
        labelFull.setVisible(false);
        labelDeleted.setText("");
        labelAlert.setText("");

    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public void setLabelName(JLabel labelName) {
        this.labelName = labelName;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JLabel getLabelLocation() {
        return labelLocation;
    }

    public void setLabelLocation(JLabel labelLocation) {
        this.labelLocation = labelLocation;
    }

    public JTextField getTxtLocation() {
        return txtLocation;
    }

    public void setTxtLocation(JTextField txtLocation) {
        this.txtLocation = txtLocation;
    }

    public JLabel getLabelAtractions() {
        return labelAtractions;
    }

    public void setLabelAtractions(JLabel labelAtractions) {
        this.labelAtractions = labelAtractions;
    }

    public JTextField getTxtAtractions() {
        return txtAtractions;
    }

    public void setTxtAtractions(JTextField txtAtractions) {
        this.txtAtractions = txtAtractions;
    }

    public JLabel getLabelCost() {
        return labelCost;
    }

    public void setLabelCost(JLabel labelCost) {
        this.labelCost = labelCost;
    }

    public JTextField getTxtCost() {
        return txtCost;
    }

    public void setTxtCost(JTextField txtCost) {
        this.txtCost = txtCost;
    }

    public JLabel getLabelCapacity() {
        return labelCapacity;
    }

    public void setLabelCapacity(JLabel labelCapacity) {
        this.labelCapacity = labelCapacity;
    }

    public JTextField getTxtCapacity() {
        return txtCapacity;
    }

    public void setTxtCapacity(JTextField txtCapacity) {
        this.txtCapacity = txtCapacity;
    }

    public JLabel getLabelStars() {
        return labelStars;
    }

    public void setLabelStars(JLabel labelStars) {
        this.labelStars = labelStars;
    }

    public JTextField getTxtStars() {
        return txtStars;
    }

    public void setTxtStars(JTextField txtStars) {
        this.txtStars = txtStars;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(JButton btnRegister) {
        this.btnRegister = btnRegister;
    }

    public JButton getBtnClean() {
        return btnClean;
    }

    public void setBtnClean(JButton btnClean) {
        this.btnClean = btnClean;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JLabel getLabelFull() {
        return labelFull;
    }

    public void setLabelFull(JLabel labelFull) {
        this.labelFull = labelFull;
    }

    public JLabel getLabelDeleted() {
        return labelDeleted;
    }

    public void setLabelDeleted(JLabel labelDeleted) {
        this.labelDeleted = labelDeleted;
    }

    public JLabel getLabelAlert() {
        return labelAlert;
    }

    public void setLabelAlert(JLabel labelAlert) {
        this.labelAlert = labelAlert;
    }
}
