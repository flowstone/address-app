package xueyao.address.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import xueyao.address.MainApp;
import xueyao.address.model.Person;
import xueyao.address.util.DialogUtil;

import java.time.format.DateTimeFormatter;

/**
 * @author Simon.Xue
 * @date 2019-12-17 16:41
 **/
public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    private MainApp mainApp;

    public PersonOverviewController() {

    }

    /**
     * 初始化
     */
    @FXML
    private void initialize() {
        System.out.println("++++你调用了初始化函数+++++");
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData-> cellData.getValue().lastNameProperty());

        //清空person detail
        showPersonDetails(null);

        personTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    showPersonDetails(newValue);
                });
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            DialogUtil.createInformation("错误", "不能删除");
        }
    }

    @FXML
    private void handleNewPerson() {
        Person person = new Person();
        boolean onClicked = mainApp.showPersonEditDialog(person);
        if (onClicked) {
            mainApp.getPersonObservableList().add(person);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person selectedItem = personTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedItem);
            if (okClicked) {
                showPersonDetails(selectedItem);
            }
        } else {
            DialogUtil.createInformation("No Selection",
                    "Please select a person in the table.");
        }
    }

    private void showPersonDetails(Person person) {
        if (null != person) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(person.getBirthday().format(DateTimeFormatter.ISO_DATE));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }



    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonObservableList());
    }


}
