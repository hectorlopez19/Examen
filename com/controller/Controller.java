package com.controller;

import com.model.Model;
import com.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target = view.getTxtSearch().getText();
                int index = model.search(target);
                if(index != -1) {
                    view.getTxtName().setText(model.getHotels()[index].getName());
                    view.getTxtLocation().setText(model.getHotels()[index].getLocation());
                    view.getTxtAtractions().setText(Integer.toString(model.getHotels()[index].getAtractionsNumber()));
                    view.getTxtCost().setText(Float.toString(model.getHotels()[index].getCost()));
                    view.getTxtCapacity().setText(Integer.toString(model.getHotels()[index].getCapacity()));
                    view.getTxtStars().setText(Integer.toString(model.getHotels()[index].getStars()));

                    setFields(false);

                    view.getBtnDelete().setEnabled(true);

                    cleanLabel(view.getLabelAlert());
                    view.getLabelDeleted().setText("Desea eliminar?");
                }
                else {
                    view.getLabelAlert().setText("No se encontro el hotel");
                    cleanLabel(view.getLabelDeleted());
                }
            }
        });

        this.view.getBtnRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getTxtName().getText();
                String location = view.getTxtLocation().getText();
                int atractionsNumber = Integer.parseInt(view.getTxtAtractions().getText());
                float cost = Float.parseFloat(view.getTxtCost().getText());
                int capacity = Integer.parseInt(view.getTxtCapacity().getText());
                int stars = Integer.parseInt(view.getTxtStars().getText());

                model.register(name, location, atractionsNumber, cost, capacity, stars);

                if(model.getRegisteredHotels() == model.getHotels().length) {
                    view.getBtnRegister().setEnabled(false);
                    setFields(false);
                    view.getLabelFull().setVisible(true);
                }
            }
        });

        this.view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target = view.getTxtName().getText();
                model.delete(model.search(target));
                view.getLabelDeleted().setText("Hotel eliminado");
                if(model.getRegisteredHotels() < model.getHotels().length) {
                    view.getBtnRegister().setEnabled(true);
                    view.getLabelFull().setVisible(false);
                }
            }
        });

        this.view.getBtnClean().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getTxtSearch().setText("");
                view.getTxtName().setText("");
                view.getTxtLocation().setText("");
                view.getTxtAtractions().setText("");
                view.getTxtCost().setText("");
                view.getTxtCapacity().setText("");
                view.getTxtStars().setText("");
                cleanLabel(view.getLabelAlert());
                cleanLabel(view.getLabelDeleted());

                if(model.getRegisteredHotels() < model.getHotels().length) {
                    setFields(true);
                }

                view.getBtnSearch().setEnabled(false);
                view.getBtnDelete().setEnabled(false);
                view.getBtnRegister().setEnabled(false);
                cleanLabel(view.getLabelDeleted());
            }
        });


        this.view.getTxtSearch().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enableSearchButton();
                char character = e.getKeyChar();
                if(character == KeyEvent.VK_ENTER) {
                    view.getBtnSearch().doClick();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableSearchButton();
            }
        });

        this.view.getTxtName().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enableRegisterButton();
                char character = e.getKeyChar();
                if(character == KeyEvent.VK_ENTER) {
                    view.getTxtLocation().requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableRegisterButton();
            }
        });

        this.view.getTxtLocation().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enableRegisterButton();
                char character = e.getKeyChar();
                if(character == KeyEvent.VK_ENTER) {
                    view.getTxtAtractions().requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableRegisterButton();
            }
        });

        this.view.getTxtAtractions().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enableRegisterButton();
                char character = e.getKeyChar();
                if(!isNumber(character) && !isSpecial(character)) {
                    view.getToolkit().beep();
                    e.consume();
                    view.getLabelAlert().setText("El campo de Atracciones debe ser un numero");
                }
                else {
                    cleanLabel(view.getLabelAlert());
                }
                if(character == KeyEvent.VK_ENTER) {
                    view.getTxtCost().requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableRegisterButton();
            }
        });

        this.view.getTxtCost().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enableRegisterButton();
                char character = e.getKeyChar();
                if(!isNumber(character) && character != '.' && !isSpecial(character)) {
                    view.getToolkit().beep();
                    e.consume();
                    view.getLabelAlert().setText("El campo de Costo debe ser un numero");
                }
                else {
                    cleanLabel(view.getLabelAlert());
                }
                if(character == KeyEvent.VK_ENTER) {
                    view.getTxtCapacity().requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableRegisterButton();
            }
        });

        this.view.getTxtCapacity().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                enableRegisterButton();
                char character = e.getKeyChar();
                if(!isNumber(character) && !isSpecial(character)) {
                    view.getToolkit().beep();
                    e.consume();
                    view.getLabelAlert().setText("El campo de Capacidad debe ser un numero");
                }
                else {
                    cleanLabel(view.getLabelAlert());
                }
                if(character == KeyEvent.VK_ENTER) {
                    view.getTxtStars().requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableRegisterButton();
            }
        });

        this.view.getTxtStars().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int size = 1;
                char character = e.getKeyChar();
                if((character < '0' || character > '5') && !isSpecial(character)) {
                    view.getToolkit().beep();
                    view.getLabelAlert().setText("El campo Estrellas debe ser un numero entre 0 y 5");
                    e.consume();
                }
                else {
                    cleanLabel(view.getLabelAlert());
                    if(view.getTxtStars().getText().length() >= size) {
                        view.getToolkit().beep();
                        view.getLabelAlert().setText("Mucho texto");
                        e.consume();
                    }
                    else {
                        cleanLabel(view.getLabelAlert());
                    }
                }
                if(character == KeyEvent.VK_ENTER) {
                    view.getBtnRegister().doClick();
                }
                enableRegisterButton();
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                enableRegisterButton();
            }
        });



    }

    public boolean isNumber(char character) {
        if(character >= '0' && character <= '9') {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSpecial(char character) {
        if(character == KeyEvent.VK_ENTER || character == KeyEvent.VK_BACK_SPACE || character == KeyEvent.VK_DELETE) {
            return true;
        }
        else {
            return false;
        }
    }

    public void cleanLabel(JLabel label) {
        label.setText("");
    }

    public void enableSearchButton() {
        if(view.getTxtSearch().getText().length() != 0) {
            view.getBtnSearch().setEnabled(true);
        }
        else {
            view.getBtnSearch().setEnabled(false);
        }
    }

    public void enableRegisterButton() {
        if(view.getTxtName().getText().length() != 0 && view.getTxtLocation().getText().length() != 0 && view.getTxtAtractions().getText().length() != 0 && view.getTxtCost().getText().length() != 0 && view.getTxtCapacity().getText().length() != 0 && view.getTxtStars().getText().length() != 0) {
            view.getBtnRegister().setEnabled(true);
        }
        else {
            view.getBtnRegister().setEnabled(false);
        }
    }

    public void setFields(boolean enabled) {
        view.getTxtName().setEnabled(enabled);
        view.getTxtLocation().setEnabled(enabled);
        view.getTxtAtractions().setEnabled(enabled);
        view.getTxtCost().setEnabled(enabled);
        view.getTxtCapacity().setEnabled(enabled);
        view.getTxtStars().setEnabled(enabled);

    }

    public void start() {
        view.setSize(400, 400);
        view.setLocationRelativeTo(null);
    }
}
