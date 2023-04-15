package memory;

import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.regex.Pattern;

public class HelloApplication extends Application {


        public class Person {

            private String jiha;
            private String lieu;
            private String couse;
            private LocalDate  retard;
            private LocalDate  date;
            private String sujet;
            private String classes;
            private String khasem;
            private String sifa;
            private String lastFather;
            private String lastName;
            private String firstName;
            private int id;

            public Person(String jiha, String lieu, String couse, LocalDate  retard, LocalDate  date, String sujet, String classes, String khasem, String sifa,String lastFather, String lastName, String firstName, int id) {
                this.jiha = jiha;
                this.lieu = lieu;
                this.couse = couse;
                this.retard = retard;
                this.date = date;
                this.sujet = sujet;
                this.classes = classes;
                this.khasem = khasem;
                this.sifa = sifa;
                this.lastFather = lastFather;
                this.lastName = lastName;
                this.firstName = firstName;
                this.id = id;
            }



            // Getters and setters


            public String getLastFather() {
                return lastFather;
            }

            public void setLastFather(String lastFather) {
                this.lastFather = lastFather;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setnewFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getJiha() {
                return jiha;
            }

            public void setJiha(String jiha) {
                this.jiha = jiha;
            }

            public String getLieu() {
                return lieu;
            }

            public void setLieu(String lieu) {
                this.lieu = lieu;
            }

            public String getCouse() {
                return couse;
            }

            public void setCouse(String couse) {
                this.couse = couse;
            }

            public LocalDate  getRetard() {
                return retard;
            }

            public void setRetard(LocalDate  retard) {
                this.retard = retard;
            }

            public LocalDate  getDate() {
                return date;
            }

            public void setDate(LocalDate  date) {
                this.date = date;
            }

            public String getSujet() {
                return sujet;
            }

            public void setSujet(String sujet) {
                this.sujet = sujet;
            }

            public String getClasses() {
                return classes;
            }

            public void setClasses(String classes) {
                this.classes = classes;
            }

            public String getKhasem() {
                return khasem;
            }

            public void setKhasem(String khasem) {
                this.khasem = khasem;
            }

            public String getSifa() {
                return sifa;
            }

            public void setSifa(String sifa) {
                this.sifa = sifa;
            }

            public int getId() {
                return id;
            }

            public void setid(int id) {
                this.id = id;
            }
        }

    //-------------------------------------------------------------------------------------------------------------
    private boolean isLiked = false;

    @Override
    public void start(Stage stage) throws IOException {
    	
    	BorderPane borderPane = new BorderPane();
    	borderPane.setId("borderPane");

    	Scene scene = new Scene(borderPane, 850, 600);

        stage.getIcons().add(new Image(HelloApplication.class.getResource("hammer.png").openStream()));
        stage.setTitle("Facelawyer");

//******************Login**********************************************************************************************************************************

        VBox vBox = new VBox(20);
        HBox hBox = new HBox(20);
        GridPane gridPane = new GridPane();

        Image log = new Image(HelloApplication.class.getResource("log-in.png").openStream());
        ImageView iLog = new ImageView(log);
        iLog.setFitWidth(200);
        iLog.setFitHeight(175);
        borderPane.setTop(vBox);
        vBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(20,20,0,20));
        vBox.getChildren().add(iLog);

        TextField nameUser = new TextField();
        nameUser.setId("txt");
        nameUser.setPromptText("رقم الهاتف أو الإمايل");
        nameUser.setPrefWidth(250);
        nameUser.setFocusTraversable(false);
        gridPane.add(nameUser,1,0);

        Image imUtl = new Image(HelloApplication.class.getResource("contact.png").openStream());
        ImageView iUtl = new ImageView(imUtl);
        iUtl.setFitWidth(30);
        iUtl.setFitHeight(30);
        borderPane.setCenter(iUtl);
        gridPane.add(iUtl,0,0);

        PasswordField passUser = new PasswordField();
        passUser.setId("txt");
        passUser.setPromptText("كلمة المرور");
        passUser.setPrefWidth(250);
        passUser.setFocusTraversable(false);
        gridPane.add(passUser,1,1);

        Image imPas = new Image((HelloApplication.class.getResource("mot_de_passe.png").openStream()));
        ImageView iPas = new ImageView(imPas);
        iPas.setFitWidth(25);
        iPas.setFitHeight(25);
        borderPane.setCenter(iPas);
        gridPane.add(iPas,0,1);

        BorderPane.setAlignment(gridPane,Pos.CENTER);
        borderPane.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(30,0,0,0));

        iUtl.setManaged(false);
        iPas.setManaged(false);

        iUtl.setLayoutX(265);
        iUtl.setLayoutY(93);
        iPas.setLayoutX(267);
        iPas.setLayoutY(137);

//************Animation************************************************************************************************************************************
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), 2)),
                new KeyFrame(Duration.seconds(0.125),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.25),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), +5)),
                new KeyFrame(Duration.seconds(0.375),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.5),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), +5)),
                new KeyFrame(Duration.seconds(0.625),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.75),
                        new javafx.animation.KeyValue(nameUser.translateXProperty(), 0))
        );

        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), 2)),
                new KeyFrame(Duration.seconds(0.125),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.25),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), +5)),
                new KeyFrame(Duration.seconds(0.375),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.5),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), +5)),
                new KeyFrame(Duration.seconds(0.625),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.75),
                        new javafx.animation.KeyValue(passUser.translateXProperty(), 0))
        );

//****************************************************************************************************************************************************************

        VBox vBoxBottom = new VBox(20);
        Button btnLogin = new Button("تسجيل الدخول");
        btnLogin.setId("btnLogin");
        btnLogin.setFocusTraversable(true);

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (nameUser.getText().isEmpty() ){
                    nameUser.setStyle("-fx-border-color: red");
                    timeline.play();

                }
                else{
                    nameUser.setStyle("-fx-border-color: white");
                }

                if (passUser.getText().isEmpty()){
                    passUser.setStyle("-fx-border-color: red");
                    timeline1.play();
                }

                else{
                    passUser.setStyle("-fx-border-color: white");
                }

                if (nameUser.getText().equals(passUser.getText())){

//*********Home Page************************************************************************************************************************************************

                    Pane premaire = new Pane();
                    premaire.setId("group");
                    HBox hbox = new HBox();
                    Scene scene3 = new Scene(premaire, 1450, 790);

                    Image home;
                    try {
                        home = new Image(HelloApplication.class.getResource("home.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iHome = new ImageView(home);
                    iHome.setFitWidth(32);
                    iHome.setFitHeight(32);

                    Image home1;
                    try {
                        home1 = new Image(HelloApplication.class.getResource("home1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iHome1 = new ImageView(home1);
                    iHome1.setFitWidth(32);
                    iHome1.setFitHeight(32);

                    Image people;
                    try {
                        people = new Image(HelloApplication.class.getResource("group1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                    ImageView iPeople = new ImageView(people);
                    iPeople.setFitWidth(32);
                    iPeople.setFitHeight(32);

                    Image people1;
                    try {
                        people1 = new Image(HelloApplication.class.getResource("group2.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iPeople1 = new ImageView(people1);
                    iPeople1.setFitWidth(32);
                    iPeople1.setFitHeight(32);

                    Image telephone;
                    try {
                        telephone = new Image(HelloApplication.class.getResource("phone1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iTelephone = new ImageView(telephone);
                    iTelephone.setFitWidth(32);
                    iTelephone.setFitHeight(32);

                    Image telephone1;
                    try {
                        telephone1 = new Image(HelloApplication.class.getResource("phone.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iTelephone1 = new ImageView(telephone1);
                    iTelephone1.setFitWidth(32);
                    iTelephone1.setFitHeight(32);

                    Image contract;
                    try {
                        contract = new Image(HelloApplication.class.getResource("contract1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iContract = new ImageView(contract);
                    iContract.setFitWidth(32);
                    iContract.setFitHeight(32);

                    Image contract1;
                    try {
                        contract1 = new Image(HelloApplication.class.getResource("contract.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iContract1 = new ImageView(contract1);
                    iContract1.setFitWidth(32);
                    iContract1.setFitHeight(32);

                    Image temp;
                    try {
                        temp = new Image(HelloApplication.class.getResource("calendar.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iTemp = new ImageView(temp);
                    iTemp.setFitWidth(32);
                    iTemp.setFitHeight(32);

                    Image temp1;
                    try {
                        temp1 = new Image(HelloApplication.class.getResource("calendar1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iTemp1 = new ImageView(temp1);
                    iTemp1.setFitWidth(32);
                    iTemp1.setFitHeight(32);

                    Image profil;
                    try {
                        profil = new Image(HelloApplication.class.getResource("man1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iProfil = new ImageView(profil);
                    iProfil.setFitWidth(50);
                    iProfil.setFitHeight(50);


                    ToggleButton btnHome = new ToggleButton();
                    btnHome.setGraphic(iHome);
                    btnHome.setSelected(true);
                    btnHome.setLayoutX(850);
                    btnHome.setLayoutY(30);
                    btnHome.setStyle("-fx-background-color: transparent");
                    btnHome.setId("btnPar");
                    btnHome.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(scene3);
                            stage.show();
                        }
                    });

                    ToggleButton btnTelephone = new ToggleButton();
                    btnTelephone.setGraphic(iTelephone);
                    btnTelephone.setLayoutX(550);
                    btnTelephone.setLayoutY(30);
                    btnTelephone.setStyle("-fx-background-color: transparent");
                    btnTelephone.setId("btnPar");

                    ToggleButton btnPeople = new ToggleButton();
                    btnPeople.setGraphic(iPeople);
                    btnPeople.setLayoutX(700);
                    btnPeople.setLayoutY(30);
                    btnPeople.setStyle("-fx-background-color: transparent");
                    btnPeople.setId("btnPar");

                    ToggleButton btnContract = new ToggleButton();
                    btnContract.setGraphic(iContract);
                    btnContract.setSelected(true);
                    btnContract.setLayoutX(400);
                    btnContract.setLayoutY(30);
                    btnContract.setStyle("-fx-background-color: transparent");
                    btnContract.setId("btnPar");

                    ToggleButton btnTemp = new ToggleButton();
                    btnTemp.setGraphic(iTemp);
                    btnTemp.setLayoutX(250);
                    btnTemp.setLayoutY(30);
                    btnTemp.setStyle("-fx-background-color: transparent");
                    btnTemp.setId("btnPar");

                    ToggleButton btnProfil = new ToggleButton();
                    btnProfil.setGraphic(iProfil);
                    btnProfil.setLayoutX(75);
                    btnProfil.setLayoutY(20);
                    btnProfil.setStyle("-fx-background-color: transparent");
                    btnProfil.setId("btnPar");

                    ToggleGroup group = new ToggleGroup();
                    btnContract.setToggleGroup(group);
                    btnContract.setToggleGroup(group);

                    btnHome.setOnAction(event -> {
                        if (btnHome.isSelected()) {
                            btnTemp.setGraphic(iTemp);
                            btnHome.setGraphic(iHome);
                            btnContract.setGraphic(iContract);
                            btnTelephone.setGraphic(iTelephone);
                            btnPeople.setGraphic(iPeople);
                        }
                    });
                    btnTelephone.setOnAction(event -> {
                        if (btnTelephone.isSelected()) {
                            btnContract.setGraphic(iContract);
                            btnTelephone.setGraphic(iTelephone1);
                            btnTemp.setGraphic(iTemp);
                            btnHome.setGraphic(iHome1);
                            btnPeople.setGraphic(iPeople);
                        }
                    });

                    btnPeople.setOnAction(event -> {
                        if (btnPeople.isSelected()) {
                            btnContract.setGraphic(iContract);
                            btnTelephone.setGraphic(iTelephone);
                            btnTemp.setGraphic(iTemp);
                            btnHome.setGraphic(iHome1);
                            btnPeople.setGraphic(iPeople1);
                        }
                    });

                    btnContract.setOnAction(event -> {
                        if (btnContract.isSelected()) {

                            btnTelephone.setGraphic(iTelephone);

                            btnHome.setGraphic(iHome1);
                            btnPeople.setGraphic(iPeople);
                            btnTemp.setGraphic(iTemp);
                            btnContract.setGraphic(iContract1);
                        }
                    });
                    btnTemp.setOnAction(event -> {
                        if (btnTemp.isSelected()) {

                            btnTelephone.setGraphic(iTelephone);

                            btnHome.setGraphic(iHome1);
                            btnPeople.setGraphic(iPeople);
                            btnContract.setGraphic(iContract);
                            btnTemp.setGraphic(iTemp1);
                        }
                    });

                    btnTemp.setLayoutX(250);
                    btnTemp.setLayoutY(30);
                    btnTemp.setGraphic(iTemp);
                    btnTemp.setStyle("-fx-background-color: transparent");

                    Button btnLogo = new Button();

                    Image logo;
                    try {
                        logo = new Image(HelloApplication.class.getResource("hammer.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iLogo = new ImageView(logo);
                    iLogo.setFitWidth(50);
                    iLogo.setFitHeight(50);

                    btnLogo.setGraphic(iLogo);
                    btnLogo.setStyle("-fx-background-color: transparent");
                    btnLogo.setLayoutX(1170);
                    btnLogo.setLayoutY(20);

                    hbox.setSpacing(50);
                    hbox.setPadding(new Insets(20,300,60,1090));
                    hbox.setId("hbox");

                    hbox.setLayoutX(10);
                    hbox.setLayoutY(10);

                    VBox vbox = new VBox();

                    ListView<String> listView = new ListView<>();

                    listView.setId("listView");
                    listView.getItems().addAll("Iron Man","Titanic","Contact","Surrogates");
                    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                    TextField searchField = new TextField();
                    searchField.setId("search");
                    searchField.setPromptText("البحث عن موكل");
                    searchField.setFocusTraversable(false);
                    FilteredList<String> filteredList = new FilteredList<>(listView.getItems());
                    listView.setItems(filteredList);

                    searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                        filteredList.setPredicate(item -> {
                            if (newValue == null || newValue.isEmpty()) {
                                return true; // show all items when search field is empty
                            }
                            String lowerCaseFilter = newValue.toLowerCase();
                            return item.toLowerCase().contains(lowerCaseFilter);
                        });
                    });

                    Button a8 = new Button("Log out");

                    vbox.setPadding(new Insets(20,20,20,20));
                    vbox.setSpacing(10);
                    vbox.setId("Vbox");

                    VBox vBox1 = new VBox();
                    vBox1.setPadding(new Insets(85,0,0,0));

                    vbox.getChildren().addAll(searchField,listView,vBox1,a8);
                    vbox.setLayoutX(1059);
                    vbox.setLayoutY(100);

                    Font font = Font.font("Amiri Quran",17);

                    Label qurane = new Label("بسم الله الرحمن الرحيم");
                    qurane.setId("Qurane");
                    qurane.setLayoutX(500);
                    qurane.setLayoutY(150);
                    qurane.setFont(font);

                    Label qurane1 = new Label(" ﴿إِنَّ اللَّهَ يَأْمُرُكُمْ أَنْ تُؤَدُّوا الْأَمَانَاتِ إِلَى أَهْلِهَا وَإِذَا حَكَمْتُمْ بَيْنَ النَّاسِ أَنْ تَحْكُمُوا بِالْعَدْلِ إِنَّ اللَّهَ نِعِمَّا يَعِظُكُمْ بِهِ إِنَّ اللَّهَ كَانَ سَمِيعًا بَصِيرًا﴾\n ");
                    qurane1.setLayoutX(85);
                    qurane1.setLayoutY(200);
                    qurane1.setId("Qurane");
                    qurane1.setFont(font);

                    Button m100 = new Button("المواعيد");
                    m100.setId("btnRapid");
                    m100.setLayoutX(800);
                    m100.setLayoutY(330);
                    Button m11 = new Button("جهات الاتصال");
                    m11.setId("btnRapid");
                    m11.setLayoutX(550);
                    m11.setLayoutY(330);
                    Button m2 = new Button("إدارة القضايا");
                    m2.setId("btnRapid");
                    m2.setLayoutX(300);
                    m2.setLayoutY(330);
                    m2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Group groupM1 = new Group();
                            HBox hboxM1 = new HBox();
                            Scene sceneM1 = new Scene(groupM1,1450, 790);

                            Image home;
                            try {
                                home = new Image(HelloApplication.class.getResource("home.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iHome = new ImageView(home);
                            iHome.setFitWidth(32);
                            iHome.setFitHeight(32);

                            Image home1;
                            try {
                                home1 = new Image(HelloApplication.class.getResource("home1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iHome1 = new ImageView(home1);
                            iHome1.setFitWidth(32);
                            iHome1.setFitHeight(32);

                            Image people;
                            try {
                                people = new Image(HelloApplication.class.getResource("group1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iPeople = new ImageView(people);
                            iPeople.setFitWidth(32);
                            iPeople.setFitHeight(32);

                            Image people1;
                            try {
                                people1 = new Image(HelloApplication.class.getResource("group2.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iPeople1 = new ImageView(people1);
                            iPeople1.setFitWidth(32);
                            iPeople1.setFitHeight(32);

                            Image telephone;
                            try {
                                telephone = new Image(HelloApplication.class.getResource("phone1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iTelephone = new ImageView(telephone);
                            iTelephone.setFitWidth(32);
                            iTelephone.setFitHeight(32);

                            Image telephone1;
                            try {
                                telephone1 = new Image(HelloApplication.class.getResource("phone.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iTelephone1 = new ImageView(telephone1);
                            iTelephone1.setFitWidth(32);
                            iTelephone1.setFitHeight(32);

                            Image contract;
                            try {
                                contract = new Image(HelloApplication.class.getResource("contract1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iContract = new ImageView(contract);
                            iContract.setFitWidth(32);
                            iContract.setFitHeight(32);

                            Image contract1;
                            try {
                                contract1 = new Image(HelloApplication.class.getResource("contract.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iContract1 = new ImageView(contract1);
                            iContract1.setFitWidth(32);
                            iContract1.setFitHeight(32);

                            Image temp;
                            try {
                                temp = new Image(HelloApplication.class.getResource("calendar.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iTemp = new ImageView(temp);
                            iTemp.setFitWidth(32);
                            iTemp.setFitHeight(32);

                            Image temp1;
                            try {
                                temp1 = new Image(HelloApplication.class.getResource("calendar1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iTemp1 = new ImageView(temp1);
                            iTemp1.setFitWidth(32);
                            iTemp1.setFitHeight(32);

                            Image profil;
                            try {
                                profil = new Image(HelloApplication.class.getResource("man1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iProfil = new ImageView(profil);
                            iProfil.setFitWidth(50);
                            iProfil.setFitHeight(50);

                            ToggleButton btnHome = new ToggleButton();
                            btnHome.setGraphic(iHome);
                            btnHome.setSelected(true);
                            btnHome.setLayoutX(850);
                            btnHome.setLayoutY(30);
                            btnHome.setStyle("-fx-background-color: transparent");
                            btnHome.setId("btnPar");


                            ToggleButton btnTelephone = new ToggleButton();
                            btnTelephone.setGraphic(iTelephone);
                            btnTelephone.setLayoutX(550);
                            btnTelephone.setLayoutY(30);
                            btnTelephone.setStyle("-fx-background-color: transparent");
                            btnTelephone.setId("btnPar");

                            ToggleButton btnPeople = new ToggleButton();
                            btnPeople.setGraphic(iPeople);
                            btnPeople.setLayoutX(700);
                            btnPeople.setLayoutY(30);
                            btnPeople.setStyle("-fx-background-color: transparent");
                            btnPeople.setId("btnPar");

                            ToggleButton btnContract = new ToggleButton();
                            btnContract.setGraphic(iContract);
                            btnContract.setSelected(true);
                            btnContract.setLayoutX(400);
                            btnContract.setLayoutY(30);
                            btnContract.setStyle("-fx-background-color: transparent");
                            btnContract.setId("btnPar");

                            ToggleButton btnTemp = new ToggleButton();
                            btnTemp.setGraphic(iTemp);
                            btnTemp.setLayoutX(250);
                            btnTemp.setLayoutY(30);
                            btnTemp.setStyle("-fx-background-color: transparent");
                            btnTemp.setId("btnPar");

                            ToggleButton btnProfil = new ToggleButton();
                            btnProfil.setGraphic(iProfil);
                            btnProfil.setLayoutX(75);
                            btnProfil.setLayoutY(20);
                            btnProfil.setStyle("-fx-background-color: transparent");
                            btnProfil.setId("btnPar");

                            ToggleGroup group = new ToggleGroup();
                            btnContract.setToggleGroup(group);
                            btnContract.setToggleGroup(group);

                            btnHome.setOnAction(event -> {
                                if (btnHome.isSelected()) {
                                    btnTemp.setGraphic(iTemp);
                                    btnHome.setGraphic(iHome);
                                    btnContract.setGraphic(iContract);
                                    btnTelephone.setGraphic(iTelephone);
                                    btnPeople.setGraphic(iPeople);

                                    stage.setScene(scene3);
                                    stage.show();

                                }
                            });
                            btnTelephone.setOnAction(event -> {
                                if (btnTelephone.isSelected()) {
                                    btnContract.setGraphic(iContract);
                                    btnTelephone.setGraphic(iTelephone1);
                                    btnTemp.setGraphic(iTemp);
                                    btnHome.setGraphic(iHome1);
                                    btnPeople.setGraphic(iPeople);
                                }
                            });

                            btnPeople.setOnAction(event -> {
                                if (btnPeople.isSelected()) {
                                    btnContract.setGraphic(iContract);
                                    btnTelephone.setGraphic(iTelephone);
                                    btnTemp.setGraphic(iTemp);
                                    btnHome.setGraphic(iHome1);
                                    btnPeople.setGraphic(iPeople1);
                                }
                            });

                            btnContract.setOnAction(event -> {
                                if (btnContract.isSelected()) {
                                    btnTelephone.setGraphic(iTelephone);
                                    btnHome.setGraphic(iHome1);
                                    btnPeople.setGraphic(iPeople);
                                    btnTemp.setGraphic(iTemp);
                                    btnContract.setGraphic(iContract1);
                                }
                            });
                            btnTemp.setOnAction(event -> {
                                if (btnTemp.isSelected()) {
                                    btnTelephone.setGraphic(iTelephone);
                                    btnHome.setGraphic(iHome1);
                                    btnPeople.setGraphic(iPeople);
                                    btnContract.setGraphic(iContract);
                                    btnTemp.setGraphic(iTemp1);
                                }
                            });


                            Button addClient = new Button("اضافة");
                            Button delClient = new Button("حدف");
                            Button regClient = new Button("تعديل");

                            addClient.setId("btnaddClient");
                            addClient.setLayoutX(30);
                            addClient.setLayoutY(150);

                            delClient.setId("btndelClient");
                            delClient.setLayoutX(280);
                            delClient.setLayoutY(150);

                            regClient.setId("btnregClient");
                            regClient.setLayoutX(530);
                            regClient.setLayoutY(150);

                            TableView<Person> tableView = new TableView<>();

                            TableView<Person> table = new TableView<Person>();

                            TableColumn<Person, String> lastNameColumn = new TableColumn<>("إسم الموكل");
                            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                            lastNameColumn.prefWidthProperty().set(100);
                            lastNameColumn.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("لقب الموكل");
                            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                            firstNameCol.prefWidthProperty().set(100);
                            firstNameCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> jihaCol = new TableColumn<Person, String>("الجهة القضائية");
                            jihaCol.setCellValueFactory(new PropertyValueFactory<Person, String>("jiha"));
                            jihaCol.prefWidthProperty().set(100);
                            jihaCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> lieuCol = new TableColumn<Person, String>("مكان الجلسة");
                            lieuCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lieu"));
                            lieuCol.prefWidthProperty().set(100);
                            lieuCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> couseCol = new TableColumn<Person, String>("سبب التأجيل");
                            couseCol.setCellValueFactory(new PropertyValueFactory<Person, String>("couse"));
                            couseCol.prefWidthProperty().set(100);
                            couseCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, LocalDate> retardCol = new TableColumn<Person, LocalDate>("تأجيل الجلسة");
                            retardCol.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("retard"));
                            retardCol.prefWidthProperty().set(100);
                            retardCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, LocalDate> dateCol = new TableColumn<Person, LocalDate>("تاريخ الجلسة");
                            dateCol.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("date"));
                            dateCol.prefWidthProperty().set(100);
                            dateCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> sujetCol = new TableColumn<Person, String>("الموضوع");
                            sujetCol.setCellValueFactory(new PropertyValueFactory<Person, String>("sujet"));
                            sujetCol.prefWidthProperty().set(107);
                            sujetCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> classesCol = new TableColumn<Person, String>("القسم او الغرفة");
                            classesCol.setCellValueFactory(new PropertyValueFactory<Person, String>("classes"));
                            classesCol.prefWidthProperty().set(100);
                            classesCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> khasemCol = new TableColumn<Person, String>("الخصم");
                            khasemCol.setCellValueFactory(new PropertyValueFactory<Person, String>("khasem"));
                            khasemCol.prefWidthProperty().set(100);
                            khasemCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> sifaCol = new TableColumn<Person, String>("صفة الموكل");
                            sifaCol.setCellValueFactory(new PropertyValueFactory<Person, String>("sifa"));
                            sifaCol.prefWidthProperty().set(100);
                            sifaCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, Integer> idCol = new TableColumn<Person, Integer>("رقم القضية");
                            idCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
                            idCol.prefWidthProperty().set(100);
                            idCol.setStyle("-fx-alignment: CENTER;");

                            TableColumn<Person, String> lastFatherCol = new TableColumn<>("إسم الأب");
                            lastFatherCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastFather"));
                            lastFatherCol.prefWidthProperty().set(100);
                            lastFatherCol.setStyle("-fx-alignment: CENTER;");

                            tableView.getColumns().addAll(jihaCol,lieuCol,couseCol,retardCol,dateCol,sujetCol,classesCol,khasemCol,sifaCol,lastFatherCol,lastNameColumn,firstNameCol,idCol);

                            ObservableList<Person> data = FXCollections.observableArrayList(
                                    new Person("jjjjjj","Paris", "Math"  ,LocalDate.of(1990, 5, 15),LocalDate.of(1990, 5, 15),"hh" ,"Algebra","10A","John Doe","اب","اسم","لقب",123456789),
                                    new Person("dsff","rida","kamel2", LocalDate.of(1990, 5, 15),LocalDate.of(1990, 5, 15),"jenah2", "kkkkkkkkk2" ,"2023/2/22", "dfghjkl","20/02/2024","mmmmmmm2","kjkjkj2",2)
                            );

                            tableView.setItems(data);

                            TextField searchField = new TextField();
                            searchField.setId("search");
                            searchField.setPromptText("البحث عن موكل");
                            searchField.setAlignment(Pos.CENTER);
                            searchField.setLayoutX(1030);
                            searchField.setLayoutY(155);

                            Stack<Person> deletedPersons = new Stack<>();
//**********del button*****************************************************************************************************************************************
                            delClient.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
                                    if (selectedPerson == null) {
                                        // If no person is selected, display an error message
                                        Alert alert = new Alert(Alert.AlertType.ERROR, "من فضلك اختر قضية لحذفها.");
                                        alert.showAndWait();
                                    }else{
                                        delClient.setOnAction((ActionEvent event) -> {
                                            Person person = tableView.getSelectionModel().getSelectedItem();
                                            if (person != null) {
                                                data.remove(person);
                                                deletedPersons.push(person);
                                            }
                                        });
                                    }
                                }
                            });
//*********modity button*****************************************************************************************************************************************
                            regClient.setOnAction(event -> {
                                // Get the selected person from the table view
                                Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
                                if (selectedPerson == null) {
                                    // If no person is selected, display an error message
                                    Alert alert = new Alert(Alert.AlertType.ERROR, "من فضلك اختر قضية للتعديل عليها.");
                                    alert.showAndWait();
                                } else {


                                    // Create a new stage for modifying the person
                                    Stage modifyStage = new Stage();
                                    BoxBlur blur = new BoxBlur();
                                    blur.setWidth(10);
                                    blur.setHeight(10);
                                    blur.setIterations(3);
                                    stage.getScene().getRoot().setEffect(blur);

                                    GridPane formPane = new GridPane();
                                    formPane.setPadding(new Insets(20 ,20, 20, 20));
                                    formPane.setHgap(20);
                                    formPane.setVgap(20);
                                    modifyStage.initStyle(StageStyle.UNDECORATED);
                                    // Add fields for each attribute of the Person class
                                    ObservableList<String> jihaOptions = FXCollections.observableArrayList(
                                            "المحكمة", "المحكمة العليا", "المحكمة الإدارية","المحكمة العسكرية","محكمة الجنايات","مجلس الدولة"
                                    );
                                    ChoiceBox<String> johaField = new ChoiceBox<>(jihaOptions);
                                    johaField.setValue(selectedPerson.getJiha());
                                    johaField.setId("feild");
                                    johaField.setPrefWidth(200);

                                    ObservableList<String> sivaOptions = FXCollections.observableArrayList(
                                            "المحكمة", "المحكمة العليا", "المحكمة الإدارية","المحكمة العسكرية","محكمة الجنايات","مجلس الدولة"
                                    );
                                    ChoiceBox<String> sivaChoiceBox = new ChoiceBox<>(sivaOptions);
                                    sivaChoiceBox.setValue(selectedPerson.getSifa());
                                    sivaChoiceBox.setId("feild");
                                    sivaChoiceBox.setPrefWidth(200);

                                    // create input fields for the person properties
                                    ObservableList<String> lieuOptions = FXCollections.observableArrayList(
                                            "محكمة توقرت", "محكمة ورقلة","محكمة الوادي","محكمة الحزائر","محكمة وهران"
                                    );
                                    ChoiceBox<String> lieuChoiceBox = new ChoiceBox<>(lieuOptions);
                                    lieuChoiceBox.setValue(selectedPerson.getLieu());
                                    lieuChoiceBox.setId("feild");
                                    lieuChoiceBox.setPrefWidth(200);

                                    ObservableList<String> classesOptions = FXCollections.observableArrayList(
                                            "عقاري", "تجاري","جزائي","شؤون الاسرة","مدني"
                                    );
                                    ChoiceBox<String> classesChoiceBox = new ChoiceBox<>(classesOptions);
                                    classesChoiceBox.setValue(selectedPerson.getClasses());
                                    classesChoiceBox.setId("feild");
                                    classesChoiceBox.setPrefWidth(200);

                                    TextField couseField = new TextField(selectedPerson.getCouse());
                                    couseField.setId("feild");
                                    couseField.setPrefWidth(200);
                                    DatePicker retardField = new DatePicker(selectedPerson.getRetard());
                                    retardField.setId("feild");
                                    retardField.setStyle("-fx-background-color: transparent;");
                                    retardField.setPrefWidth(200);
                                    DatePicker dateField = new DatePicker(selectedPerson.getDate());
                                    dateField.setId("feild");
                                    dateField.setPrefWidth(200);
                                    TextField sujetField = new TextField(selectedPerson.getSujet());
                                    sujetField.setId("feild");
                                    sujetField.setPrefWidth(200);
                                    TextField khasemChoiceBox = new TextField(selectedPerson.getKhasem());
                                    khasemChoiceBox.setId("feild");
                                    khasemChoiceBox.setPrefWidth(200);
                                    TextField lastFatherField = new TextField(selectedPerson.getLastFather());
                                    lastFatherField.setId("feild");
                                    lastFatherField.setPrefWidth(200);
                                    TextField lastNameField = new TextField(selectedPerson.getLastName());
                                    lastNameField.setId("feild");
                                    lastNameField.setPrefWidth(200);
                                    TextField firstNameField = new TextField(selectedPerson.getFirstName());
                                    firstNameField.setId("feild");
                                    firstNameField.setPrefWidth(200);
                                    TextField idField = new TextField(String.valueOf(selectedPerson.getId()));
                                    idField.setId("feild");
                                    idField.setPrefWidth(200);

                                    Label j = new Label("الجهة القضائية : *");
                                    Label l = new Label("مكان الجلسة : *");
                                    Label c = new Label("سبب التأجيل :");
                                    Label r = new Label("تاريخ التأجيل :");
                                    Label d = new Label("تاريخ الجلسة : *");
                                    Label s = new Label("الموضوع : *");
                                    Label cl = new Label("القسم أو الغرفة : *");
                                    Label k =new Label("الخصم : *");
                                    Label f =new Label("إسم الأب :");
                                    Label ls =new Label("إسم الموكل : *");
                                    Label si =new Label("صفةالموكل : *");
                                    Label fn =new Label("لقب الموكل : *");
                                    Label i =new Label("رقم القضية : *");

                                    Pattern pattern = Pattern.compile("\\d*"); // regular expression for digits
                                    TextFormatter<String> idFormatter = new TextFormatter<>(change -> {
                                        String newText = change.getControlNewText();
                                        if (pattern.matcher(newText).matches()) {
                                            return change;
                                        } else {
                                            return null; // reject the change
                                        }
                                    });

                                    j.setId("lable");
                                    //j.setAlignment(Pos.CENTER);
                                    formPane.add(j, 3,3);
                                    formPane.add(johaField, 2,3);


                                    l.setId("lable");
                                    formPane.add(l, 5,3);
                                    formPane.add(lieuChoiceBox, 4,3);


                                    c.setId("lable");
                                    formPane.add(c, 1,4);
                                    formPane.add(couseField, 0,4);


                                    r.setId("lable");
                                    formPane.add(r, 3,4);
                                    formPane.add(retardField, 2,4);


                                    d.setId("lable");
                                    formPane.add(d, 5,4);
                                    formPane.add(dateField, 4,4);


                                    s.setId("lable");
                                    formPane.add(s, 1,3);
                                    formPane.add(sujetField, 0,3);


                                    cl.setId("lable");
                                    formPane.add(cl, 1,2);
                                    formPane.add(classesChoiceBox, 0,2);


                                    k.setId("lable");
                                    formPane.add(k, 3,2);
                                    formPane.add(khasemChoiceBox, 2,2);


                                    f.setId("lable");
                                    formPane.add(f, 1,1);
                                    formPane.add(lastFatherField, 0,1);


                                    ls.setId("lable");
                                    formPane.add(ls, 3,1);
                                    formPane.add(lastNameField, 2,1);


                                    si.setId("lable");
                                    formPane.add(si, 5,2);
                                    formPane.add(sivaChoiceBox, 4,2);


                                    fn.setId("lable");
                                    formPane.add(fn, 5,1);
                                    formPane.add(firstNameField, 4,1);


                                    i.setId("lable");
                                    formPane.add(i, 3,0);
                                    formPane.add(idField, 2,0);

                                    //*************Animation*********************************************************************************************************************************

                                    Timeline timeline = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(firstNameField.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(firstNameField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(firstNameField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(firstNameField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(firstNameField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(firstNameField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(firstNameField.translateXProperty(), 0))
                                    );

                                    Timeline timeline1 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(idField.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(idField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(idField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(idField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(idField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(idField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(idField.translateXProperty(), 0))
                                    );

                                    Timeline timeline2 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(lastNameField.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(lastNameField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(lastNameField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(lastNameField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(lastNameField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(lastNameField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(lastNameField.translateXProperty(), 0))
                                    );

                                    Timeline timeline3 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(khasemChoiceBox.translateXProperty(), 0))
                                    );

                                    Timeline timeline8 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(sujetField.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(sujetField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(sujetField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(sujetField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(sujetField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(sujetField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(sujetField.translateXProperty(), 0))
                                    );

                                    Timeline timeline9 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(dateField.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(dateField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(dateField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(dateField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(dateField.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(dateField.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(dateField.translateXProperty(), 0))
                                    );

                                    // Add a save button to save the changes
                                    Button saveButton = new Button("حفظ التعديلات");
                                    saveButton.setId("btnregClient");
                                    saveButton.setOnAction(saveEvent -> {

                                        selectedPerson.setJiha(johaField.getValue());
                                        selectedPerson.setSifa(sivaChoiceBox.getValue());
                                        selectedPerson.setLieu(lieuChoiceBox.getValue());
                                        selectedPerson.setCouse(couseField.getText());
                                        selectedPerson.setRetard(retardField.getValue());
                                        selectedPerson.setDate(dateField.getValue());
                                        selectedPerson.setSujet(sujetField.getText());
                                        selectedPerson.setClasses(classesChoiceBox.getValue());
                                        selectedPerson.setKhasem(khasemChoiceBox.getText());
                                        selectedPerson.setLastFather(lastFatherField.getText());
                                        selectedPerson.setLastName(lastNameField.getText());
                                        selectedPerson.setnewFirstName(firstNameField.getText());
                                        try {
                                            selectedPerson.setid(Integer.parseInt(idField.getText()));
                                        } catch (NumberFormatException e) {
                                            // If the ID field contains invalid input, display an error message
                                            Alert alert = new Alert(Alert.AlertType.ERROR, "من فضلك اختر شخص للتعديل عليه.");
                                            alert.showAndWait();
                                            return;
                                        }

                                        if (idField.getText().isEmpty()) {
                                            idField.setStyle("-fx-border-color: red");
                                            i.setStyle("-fx-text-fill: red");
                                            timeline1.play();

                                        } else {
                                            idField.setStyle("-fx-border-color: #2C9344");
                                            i.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (lastFatherField.getText().isEmpty()) {
                                            lastFatherField.setStyle("-fx-border-color: black");
                                            f.setStyle("-fx-text-fill: black");

                                        } else {
                                            lastFatherField.setStyle("-fx-border-color: #2C9344");
                                            f.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (retardField.getValue()== null) {
                                            retardField.setStyle("-fx-border-color: black");
                                            r.setStyle("-fx-text-fill: black");

                                        } else {
                                            retardField.setStyle("-fx-border-color: #2C9344");
                                            r.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (couseField.getText().isEmpty()) {
                                            couseField.setStyle("-fx-border-color: black");
                                            c.setStyle("-fx-text-fill: black");

                                        } else {
                                            couseField.setStyle("-fx-border-color: #2C9344");
                                            c.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (firstNameField.getText().isEmpty()) {
                                            firstNameField.setStyle("-fx-border-color: red");
                                            fn.setStyle("-fx-text-fill: red");
                                            timeline.play();

                                        } else {
                                            firstNameField.setStyle("-fx-border-color: #2C9344");
                                            fn.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (lastNameField.getText().isEmpty()) {
                                            lastNameField.setStyle("-fx-border-color: red");
                                            timeline2.play();
                                            ls.setStyle("-fx-text-fill: red");

                                        } else {
                                            lastNameField.setStyle("-fx-border-color: #2C9344");
                                            ls.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (sivaChoiceBox.getValue() == null) {
                                            // Create a timeline with two key frames that rotate the choice box back and forth
                                            Timeline timeline4 = new Timeline(
                                                    new KeyFrame(Duration.seconds(0),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), 2)),
                                                    new KeyFrame(Duration.seconds(0.125),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.25),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.375),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.5),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.625),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.75),
                                                            new KeyValue(sivaChoiceBox.translateXProperty(), 0))
                                            );
                                            // Set the border color of the choice box to red
                                            sivaChoiceBox.setStyle("-fx-border-color: red;");
                                            si.setStyle("-fx-text-fill: red;");
                                            // Start the timeline animation
                                            timeline4.play();

                                        } else {
                                            // Set the border color of the choice box to #2C9344
                                            sivaChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                            si.setStyle("-fx-text-fill: #2C9344;");
                                        }

                                        if (khasemChoiceBox.getText().isEmpty()) {
                                            khasemChoiceBox.setStyle("-fx-border-color: red");
                                            k.setStyle("-fx-text-fill: red");
                                            timeline3.play();

                                        } else {
                                            khasemChoiceBox.setStyle("-fx-border-color: #2C9344");
                                            k.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (classesChoiceBox.getValue() == null) {
                                            // Create a timeline with two key frames that rotate the choice box back and forth
                                            Timeline timeline5 = new Timeline(
                                                    new KeyFrame(Duration.seconds(0),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), 2)),
                                                    new KeyFrame(Duration.seconds(0.125),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.25),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.375),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.5),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.625),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.75),
                                                            new KeyValue(classesChoiceBox.translateXProperty(), 0))
                                            );
                                            // Set the border color of the choice box to red
                                            classesChoiceBox.setStyle("-fx-border-color: red;");
                                            cl.setStyle("-fx-text-fill: red;");
                                            // Start the timeline animation
                                            timeline5.play();

                                        } else {
                                            // Set the border color of the choice box to #2C9344
                                            classesChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                            cl.setStyle("-fx-text-fill: #2C9344;");
                                        }


                                        if (lieuChoiceBox.getValue() == null) {
                                            // Create a timeline with two key frames that rotate the choice box back and forth
                                            Timeline timeline6 = new Timeline(
                                                    new KeyFrame(Duration.seconds(0),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), 2)),
                                                    new KeyFrame(Duration.seconds(0.125),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.25),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.375),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.5),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.625),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.75),
                                                            new KeyValue(lieuChoiceBox.translateXProperty(), 0))
                                            );
                                            // Set the border color of the choice box to red
                                            lieuChoiceBox.setStyle("-fx-border-color: red;");
                                            l.setStyle("-fx-text-fill: red;");
                                            // Start the timeline animation
                                            timeline6.play();

                                        } else {
                                            // Set the border color of the choice box to #2C9344
                                            lieuChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                            l.setStyle("-fx-text-fill: #2C9344;");
                                        }

                                        if (johaField.getValue() == null) {
                                            // Create a timeline with two key frames that rotate the choice box back and forth
                                            Timeline timeline7 = new Timeline(
                                                    new KeyFrame(Duration.seconds(0),
                                                            new KeyValue(johaField.translateXProperty(), 2)),
                                                    new KeyFrame(Duration.seconds(0.125),
                                                            new KeyValue(johaField.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.25),
                                                            new KeyValue(johaField.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.375),
                                                            new KeyValue(johaField.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.5),
                                                            new KeyValue(johaField.translateXProperty(), +5)),
                                                    new KeyFrame(Duration.seconds(0.625),
                                                            new KeyValue(johaField.translateXProperty(), -5)),
                                                    new KeyFrame(Duration.seconds(0.75),
                                                            new KeyValue(johaField.translateXProperty(), 0))
                                            );
                                            // Set the border color of the choice box to red
                                            johaField.setStyle("-fx-border-color: red;");
                                            j.setStyle("-fx-text-fill: red;");
                                            // Start the timeline animation
                                            timeline7.play();

                                        } else {
                                            // Set the border color of the choice box to black
                                            johaField.setStyle("-fx-border-color: #2C9344;");
                                            j.setStyle("-fx-text-fill: #2C9344;");
                                        }

                                        if (sujetField.getText().isEmpty()) {
                                            sujetField.setStyle("-fx-border-color: red");
                                            s.setStyle("-fx-text-fill: red");
                                            timeline8.play();

                                        } else {
                                            sujetField.setStyle("-fx-border-color: #2C9344");
                                            s.setStyle("-fx-text-fill: #2C9344");
                                        }
                                        if (dateField.getValue()== null) {
                                            dateField.setStyle("-fx-border-color: red");
                                            d.setStyle("-fx-text-fill: red");
                                            timeline9.play();

                                        } else {
                                            dateField.setStyle("-fx-border-color: #2C9344");
                                            d.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (!idField.getText().isEmpty() && !firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && sivaChoiceBox.getValue() != null && !khasemChoiceBox.getText().isEmpty() && classesChoiceBox.getValue() != null && lieuChoiceBox.getValue() != null && johaField.getValue() != null && !sujetField.getText().isEmpty() && dateField.getValue() != null){
                                            // retrieve the values from the input fields
                                            // Update the person's details with the values from the form

                                            // Close the modify stage
                                            modifyStage.close();
                                            // Refresh the table view to show the updated person
                                            tableView.refresh();

                                        }
                                    });

                                    Button qutButton = new Button("إلغاء");
                                    qutButton.setId("btnqut");
                                    qutButton.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            modifyStage.close();
                                            stage.getScene().getRoot().setEffect(null);
                                        }

                                    });

                                    // Add the form and save button to the modify stage
                                    formPane.add(saveButton, 2,5);
                                    formPane.add(qutButton, 4,5);
                                    formPane.setId("grid");
                                    Scene modifyScene = new Scene(formPane);
                                    modifyScene.getStylesheets().add(HelloApplication.class.getResource("regClient.css").toExternalForm());
                                    // Show the modify stage

                                    modifyStage.setScene(modifyScene);
                                    modifyStage.show();
                                }
                            });

//**********back del of button*****************************************************************************************************************************************

                            Button backButton = new Button("الرجوع بخطوة");
                            backButton.setId("backBtn");
                            backButton.setOnAction((ActionEvent event) -> {
                                if (!deletedPersons.isEmpty()) {
                                    Person delPerson = deletedPersons.pop();
                                    data.add(delPerson);
                                }
                                tableView.setItems(data);
                                tableView.getSelectionModel().clearSelection();

                            });

                            backButton.setLayoutX(780);
                            backButton.setLayoutY(150);

                            FilteredList<Person> filteredData = new FilteredList<>(data, p -> true);

//***********add Person*****************************************************************************************************************************************************
                            addClient.setOnAction(e -> {

                                Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
                                // create a new window
                                Stage addPersonStage = new Stage();

                                BoxBlur blur = new BoxBlur();
                                blur.setWidth(10);
                                blur.setHeight(10);
                                blur.setIterations(3);
                                stage.getScene().getRoot().setEffect(blur);

                                addPersonStage.setTitle("إضافة موكل");

                                ObservableList<String> jihaOptions = FXCollections.observableArrayList(
                                        "المحكمة", "المحكمة العليا", "المحكمة الإدارية","المحكمة العسكرية","محكمة الجنايات","مجلس الدولة"
                                );
                                ChoiceBox<String> jihaChoiceBox = new ChoiceBox<>(jihaOptions);
                                jihaChoiceBox.setId("feild");
                                jihaChoiceBox.setPrefWidth(200);

                                ObservableList<String> sivaOptions = FXCollections.observableArrayList(
                                        "المحكمة", "المحكمة العليا", "المحكمة الإدارية","المحكمة العسكرية","محكمة الجنايات","مجلس الدولة"
                                );
                                ChoiceBox<String> sivaChoiceBox = new ChoiceBox<>(sivaOptions);
                                sivaChoiceBox.setId("feild");
                                sivaChoiceBox.setPrefWidth(200);

                                // create input fields for the person properties
                                ObservableList<String> lieuOptions = FXCollections.observableArrayList(
                                         "محكمة توقرت", "محكمة ورقلة","محكمة الوادي","محكمة الحزائر","محكمة وهران"
                                );
                                ChoiceBox<String> lieuChoiceBox = new ChoiceBox<>(lieuOptions);
                                lieuChoiceBox.setId("feild");
                                lieuChoiceBox.setPrefWidth(200);

                                ObservableList<String> classesOptions = FXCollections.observableArrayList(
                                        "عقاري", "تجاري","جزائي","شؤون الاسرة","مدني"
                                );
                                ChoiceBox<String> classesChoiceBox = new ChoiceBox<>(classesOptions);
                                classesChoiceBox.setId("feild");
                                classesChoiceBox.setPrefWidth(200);

                                TextField couseField = new TextField();
                                couseField.setId("feild");
                                couseField.setPrefWidth(200);
                                DatePicker retardField = new DatePicker();
                                retardField.setId("feild");
                                retardField.setPrefWidth(200);
                                DatePicker dateField = new DatePicker();
                                dateField.setId("feild");
                                dateField.setPrefWidth(200);
                                TextField sujetField = new TextField();
                                sujetField.setId("feild");
                                sujetField.setPrefWidth(200);
                                TextField khasemChoiceBox = new TextField();
                                khasemChoiceBox.setId("feild");
                                khasemChoiceBox.setPrefWidth(200);
                                TextField lastFatherField = new TextField();
                                lastFatherField.setId("feild");
                                lastFatherField.setPrefWidth(200);
                                TextField lastNameField = new TextField();
                                lastNameField.setId("feild");
                                lastNameField.setPrefWidth(200);
                                TextField firstNameField = new TextField();
                                firstNameField.setId("feild");
                                firstNameField.setPrefWidth(200);
                                TextField idField = new TextField();
                                idField.setId("feild");
                                idField.setPrefWidth(200);

                                Label j = new Label("الجهة القضائية : *");
                                Label l = new Label("مكان الجلسة : *");
                                Label c = new Label("سبب التأجيل :");
                                Label r = new Label("تاريخ التأجيل :");
                                Label d = new Label("تاريخ الجلسة : *");
                                Label s = new Label("الموضوع : *");
                                Label cl = new Label("القسم أو الغرفة : *");
                                Label k =new Label("الخصم : *");
                                Label f =new Label("إسم الأب :");
                                Label ls =new Label("إسم الموكل : *");
                                Label si =new Label("صفةالموكل : *");
                                Label fn =new Label("لقب الموكل : *");
                                Label i =new Label("رقم القضية : *");

                                Pattern pattern = Pattern.compile("\\d*"); // regular expression for digits
                                TextFormatter<String> idFormatter = new TextFormatter<>(change -> {
                                    String newText = change.getControlNewText();
                                    if (pattern.matcher(newText).matches()) {
                                        return change;
                                    } else {
                                        return null; // reject the change
                                    }
                                });
                                idField.setTextFormatter(idFormatter);

                                // create a save button

//*************Animation*********************************************************************************************************************************

                                Timeline timeline = new Timeline(
                                        new KeyFrame(Duration.seconds(0),
                                                new KeyValue(firstNameField.translateXProperty(), 2)),
                                        new KeyFrame(Duration.seconds(0.125),
                                                new KeyValue(firstNameField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.25),
                                                new KeyValue(firstNameField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.375),
                                                new KeyValue(firstNameField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(firstNameField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.625),
                                                new KeyValue(firstNameField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.75),
                                                new KeyValue(firstNameField.translateXProperty(), 0))
                                );

                                Timeline timeline1 = new Timeline(
                                        new KeyFrame(Duration.seconds(0),
                                                new KeyValue(idField.translateXProperty(), 2)),
                                        new KeyFrame(Duration.seconds(0.125),
                                                new KeyValue(idField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.25),
                                                new KeyValue(idField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.375),
                                                new KeyValue(idField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(idField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.625),
                                                new KeyValue(idField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.75),
                                                new KeyValue(idField.translateXProperty(), 0))
                                );

                                Timeline timeline2 = new Timeline(
                                        new KeyFrame(Duration.seconds(0),
                                                new KeyValue(lastNameField.translateXProperty(), 2)),
                                        new KeyFrame(Duration.seconds(0.125),
                                                new KeyValue(lastNameField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.25),
                                                new KeyValue(lastNameField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.375),
                                                new KeyValue(lastNameField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(lastNameField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.625),
                                                new KeyValue(lastNameField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.75),
                                                new KeyValue(lastNameField.translateXProperty(), 0))
                                );

                                Timeline timeline3 = new Timeline(
                                        new KeyFrame(Duration.seconds(0),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), 2)),
                                        new KeyFrame(Duration.seconds(0.125),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.25),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.375),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.625),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.75),
                                                new KeyValue(khasemChoiceBox.translateXProperty(), 0))
                                );

                                Timeline timeline8 = new Timeline(
                                        new KeyFrame(Duration.seconds(0),
                                                new KeyValue(sujetField.translateXProperty(), 2)),
                                        new KeyFrame(Duration.seconds(0.125),
                                                new KeyValue(sujetField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.25),
                                                new KeyValue(sujetField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.375),
                                                new KeyValue(sujetField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(sujetField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.625),
                                                new KeyValue(sujetField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.75),
                                                new KeyValue(sujetField.translateXProperty(), 0))
                                );

                                Timeline timeline9 = new Timeline(
                                        new KeyFrame(Duration.seconds(0),
                                                new KeyValue(dateField.translateXProperty(), 2)),
                                        new KeyFrame(Duration.seconds(0.125),
                                                new KeyValue(dateField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.25),
                                                new KeyValue(dateField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.375),
                                                new KeyValue(dateField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.5),
                                                new KeyValue(dateField.translateXProperty(), +5)),
                                        new KeyFrame(Duration.seconds(0.625),
                                                new KeyValue(dateField.translateXProperty(), -5)),
                                        new KeyFrame(Duration.seconds(0.75),
                                                new KeyValue(dateField.translateXProperty(), 0))
                                );

                                Button saveButton = new Button("إضافة");
                                saveButton.setId("btnaddClient");
                                saveButton.setOnAction(event -> {

                                        if (idField.getText().isEmpty()) {
                                            idField.setStyle("-fx-border-color: red");
                                            i.setStyle("-fx-text-fill: red");
                                            timeline1.play();

                                        } else {
                                            idField.setStyle("-fx-border-color: #2C9344");
                                            i.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (lastFatherField.getText().isEmpty()) {
                                            lastFatherField.setStyle("-fx-border-color: black");
                                            f.setStyle("-fx-text-fill: black");

                                        } else {
                                            lastFatherField.setStyle("-fx-border-color: #2C9344");
                                            f.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (retardField.getValue()== null) {
                                            retardField.setStyle("-fx-border-color: black");
                                            r.setStyle("-fx-text-fill: black");

                                        } else {
                                            retardField.setStyle("-fx-border-color: #2C9344");
                                            r.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (couseField.getText().isEmpty()) {
                                            couseField.setStyle("-fx-border-color: black");
                                            c.setStyle("-fx-text-fill: black");

                                        } else {
                                            couseField.setStyle("-fx-border-color: #2C9344");
                                            c.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (firstNameField.getText().isEmpty()) {
                                            firstNameField.setStyle("-fx-border-color: red");
                                            fn.setStyle("-fx-text-fill: red");
                                            timeline.play();

                                        } else {
                                            firstNameField.setStyle("-fx-border-color: #2C9344");
                                            fn.setStyle("-fx-text-fill: #2C9344");
                                        }

                                        if (lastNameField.getText().isEmpty()) {
                                            lastNameField.setStyle("-fx-border-color: red");
                                            timeline2.play();
                                            ls.setStyle("-fx-text-fill: red");

                                        } else {
                                            lastNameField.setStyle("-fx-border-color: #2C9344");
                                            ls.setStyle("-fx-text-fill: #2C9344");
                                        }

                                    if (sivaChoiceBox.getValue() == null) {
                                        // Create a timeline with two key frames that rotate the choice box back and forth
                                        Timeline timeline4 = new Timeline(
                                                new KeyFrame(Duration.seconds(0),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), 2)),
                                                new KeyFrame(Duration.seconds(0.125),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), -5)),
                                                new KeyFrame(Duration.seconds(0.25),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), +5)),
                                                new KeyFrame(Duration.seconds(0.375),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), -5)),
                                                new KeyFrame(Duration.seconds(0.5),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), +5)),
                                                new KeyFrame(Duration.seconds(0.625),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), -5)),
                                                new KeyFrame(Duration.seconds(0.75),
                                                        new KeyValue(sivaChoiceBox.translateXProperty(), 0))
                                        );
                                        // Set the border color of the choice box to red
                                        sivaChoiceBox.setStyle("-fx-border-color: red;");
                                        si.setStyle("-fx-text-fill: red;");
                                        // Start the timeline animation
                                        timeline4.play();

                                    } else {
                                        // Set the border color of the choice box to #2C9344
                                        sivaChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                        si.setStyle("-fx-text-fill: #2C9344;");
                                    }

                                        if (khasemChoiceBox.getText().isEmpty()) {
                                            khasemChoiceBox.setStyle("-fx-border-color: red");
                                            k.setStyle("-fx-text-fill: red");
                                            timeline3.play();

                                        } else {
                                            khasemChoiceBox.setStyle("-fx-border-color: #2C9344");
                                            k.setStyle("-fx-text-fill: #2C9344");
                                        }

                                    if (classesChoiceBox.getValue() == null) {
                                        // Create a timeline with two key frames that rotate the choice box back and forth
                                        Timeline timeline5 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(classesChoiceBox.translateXProperty(), 0))
                                        );
                                        // Set the border color of the choice box to red
                                        classesChoiceBox.setStyle("-fx-border-color: red;");
                                        cl.setStyle("-fx-text-fill: red;");
                                        // Start the timeline animation
                                        timeline5.play();

                                    } else {
                                        // Set the border color of the choice box to #2C9344
                                        classesChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                        cl.setStyle("-fx-text-fill: #2C9344;");
                                    }


                                    if (lieuChoiceBox.getValue() == null) {
                                        // Create a timeline with two key frames that rotate the choice box back and forth
                                        Timeline timeline6 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(lieuChoiceBox.translateXProperty(), 0))
                                        );
                                        // Set the border color of the choice box to red
                                        lieuChoiceBox.setStyle("-fx-border-color: red;");
                                        l.setStyle("-fx-text-fill: red;");
                                        // Start the timeline animation
                                        timeline6.play();

                                    } else {
                                        // Set the border color of the choice box to #2C9344
                                        lieuChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                        l.setStyle("-fx-text-fill: #2C9344;");
                                    }

                                    if (jihaChoiceBox.getValue() == null) {
                                        // Create a timeline with two key frames that rotate the choice box back and forth
                                        Timeline timeline7 = new Timeline(
                                            new KeyFrame(Duration.seconds(0),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), 2)),
                                            new KeyFrame(Duration.seconds(0.125),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.25),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.375),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.5),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), +5)),
                                            new KeyFrame(Duration.seconds(0.625),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), -5)),
                                            new KeyFrame(Duration.seconds(0.75),
                                                    new KeyValue(jihaChoiceBox.translateXProperty(), 0))
                                        );
                                        // Set the border color of the choice box to red
                                        jihaChoiceBox.setStyle("-fx-border-color: red;");
                                        j.setStyle("-fx-text-fill: red;");
                                        // Start the timeline animation
                                        timeline7.play();

                                    } else {
                                        // Set the border color of the choice box to black
                                        jihaChoiceBox.setStyle("-fx-border-color: #2C9344;");
                                        j.setStyle("-fx-text-fill: #2C9344;");
                                    }

                                    if (sujetField.getText().isEmpty()) {
                                        sujetField.setStyle("-fx-border-color: red");
                                        s.setStyle("-fx-text-fill: red");
                                        timeline8.play();

                                    } else {
                                        sujetField.setStyle("-fx-border-color: #2C9344");
                                        s.setStyle("-fx-text-fill: #2C9344");
                                    }
                                    if (dateField.getValue()== null) {
                                        dateField.setStyle("-fx-border-color: red");
                                        d.setStyle("-fx-text-fill: red");
                                        timeline9.play();

                                    } else {
                                        dateField.setStyle("-fx-border-color: #2C9344");
                                        d.setStyle("-fx-text-fill: #2C9344");
                                    }

                                    if (!idField.getText().isEmpty() && !firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty() && sivaChoiceBox.getValue() != null && !khasemChoiceBox.getText().isEmpty() && classesChoiceBox.getValue() != null && lieuChoiceBox.getValue() != null && jihaChoiceBox.getValue() != null && !sujetField.getText().isEmpty() && dateField.getValue() != null){
                                        // retrieve the values from the input fields
                                        String jiha = jihaChoiceBox.getValue();
                                        String lieu = lieuChoiceBox.getValue();
                                        String couse = couseField.getText();
                                        LocalDate retard = retardField.getValue();
                                        LocalDate date = dateField.getValue();
                                        String sujet = sujetField.getText();
                                        String classes = classesChoiceBox.getValue();
                                        String khasem = khasemChoiceBox.getText();
                                        String sifa = sivaChoiceBox.getValue();
                                        String lastFather = lastFatherField.getText();
                                        String lastName = lastNameField.getText();
                                        String firstName = firstNameField.getText();
                                        int id = Integer.parseInt(idField.getText());

                                        ObservableList<Person> personList = tableView.getItems();

                                        Person newPerson = new Person(jiha,lieu, couse, retard, date, sujet, classes, khasem,sifa, lastFather, lastName, firstName, id);
                                        data.add(newPerson);

                                        jihaChoiceBox.getSelectionModel().clearSelection();
                                        lieuChoiceBox.getSelectionModel().clearSelection();
                                        couseField.clear();
                                        retardField.setValue(null);
                                        dateField.setValue(null);
                                        sujetField.clear();
                                        classesChoiceBox.getItems().clear();
                                        classesChoiceBox.getSelectionModel().clearSelection();
                                        khasemChoiceBox.clear();
                                        lastFatherField.setText(null);
                                        lastNameField.setText(null);
                                        firstNameField.setText(null);
                                        idField.clear();
                                        addPersonStage.close();

                                    }
                                });
                                // create a layout for the new window

                                Button delButton = new Button("حذف كل");
                                delButton.setId("btndel");
                                delButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        jihaChoiceBox.getSelectionModel().clearSelection();
                                        lieuChoiceBox.getSelectionModel().clearSelection();
                                        couseField.clear();
                                        retardField.setValue(null);
                                        dateField.setValue(null);
                                        sujetField.clear();
                                        sivaChoiceBox.getSelectionModel().clearSelection();
                                        classesChoiceBox.getItems().clear();
                                        classesChoiceBox.getSelectionModel().clearSelection();
                                        khasemChoiceBox.clear();
                                        lastFatherField.setText(null);
                                        lastNameField.setText(null);
                                        firstNameField.setText(null);
                                        idField.clear();
                                    }
                                });
                                Button qutButton = new Button("إلغاء");
                                qutButton.setId("btnqut");
                                qutButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        stage.getScene().getRoot().setEffect(null);
                                        addPersonStage.close();
                                    }
                                });
                                GridPane grid = new GridPane();
                                grid.setId("grid");
                                grid.setHgap(20);
                                grid.setVgap(20);
                                grid.setPadding(new Insets(20, 20, 20, 20));


                                j.setId("lable");
                                //j.setAlignment(Pos.CENTER);
                                grid.add(j, 3,3);
                                grid.add(jihaChoiceBox, 2,3);


                                l.setId("lable");
                                grid.add(l, 5,3);
                                grid.add(lieuChoiceBox, 4,3);


                                c.setId("lable");
                                grid.add(c, 1,4);
                                grid.add(couseField, 0,4);


                                r.setId("lable");
                                grid.add(r, 3,4);
                                grid.add(retardField, 2,4);


                                d.setId("lable");
                                grid.add(d, 5,4);
                                grid.add(dateField, 4,4);


                                s.setId("lable");
                                grid.add(s, 1,3);
                                grid.add(sujetField, 0,3);


                                cl.setId("lable");
                                grid.add(cl, 1,2);
                                grid.add(classesChoiceBox, 0,2);


                                k.setId("lable");
                                grid.add(k, 3,2);
                                grid.add(khasemChoiceBox, 2,2);


                                f.setId("lable");
                                grid.add(f, 1,1);
                                grid.add(lastFatherField, 0,1);


                                ls.setId("lable");
                                grid.add(ls, 3,1);
                                grid.add(lastNameField, 2,1);


                                si.setId("lable");
                                grid.add(si, 5,2);
                                grid.add(sivaChoiceBox, 4,2);


                                fn.setId("lable");
                                grid.add(fn, 5,1);
                                grid.add(firstNameField, 4,1);


                                i.setId("lable");
                                grid.add(i, 3,0);
                                grid.add(idField, 2,0);

                                grid.add(saveButton,2,5);
                                grid.add(delButton,0,5);
                                grid.add(qutButton,4,5);

                                addPersonStage.close();

                                //data.add(newPerson);
                                tableView.setItems(data);
                                tableView.refresh();
                                // Create a new Scene for the add stage and set the layout
                                Scene addScene = new Scene(grid);
                                addScene.getStylesheets().add(HelloApplication.class.getResource("addClient.css").toExternalForm());
                                // Set the add stage's scene and show the stage
                                addPersonStage.setScene(addScene);
                                addPersonStage.show();
                            });

//**********recharche*****************************************************************************************************************************************

                            tableView.setItems(data);
                            searchField.textProperty().addListener((observable, oldValue, newValue) -> {

                                String searchText = searchField.getText().toLowerCase();
                                ObservableList<Person> filteredData1 = FXCollections.observableArrayList();
                                for (Person person : data) {
                                    if (person.getLieu().toLowerCase().contains(searchText) ||
                                        person.getJiha().toLowerCase().contains(searchText) ||
                                        person.getCouse().toLowerCase().contains(searchText) ||
                                        person.getRetard().toString().toLowerCase().contains(searchText) ||
                                        person.getDate().toString().toLowerCase().contains(searchText) ||
                                        person.getSujet().toLowerCase().contains(searchText) ||
                                        person.getClasses().toLowerCase().contains(searchText) ||
                                        person.getKhasem().toLowerCase().contains(searchText) ||
                                        person.getFirstName().toLowerCase().contains(searchText) ||
                                        person.getLastName().toLowerCase().contains(searchText) ||
                                        person.getFirstName().toLowerCase().contains(searchText) ||
                                        String.valueOf(person.getId()).toLowerCase().contains(searchText)) {
                                        filteredData1.add(person);
                                    }
                                }
                                tableView.setItems(filteredData1);

                            });

                            tableView.setItems(filteredData);

                            tableView.setLayoutX(30);
                            tableView.setLayoutY(250);

                            tableView.setStyle("-fx-background-color: #f2f2f2;");

                            btnTemp.setLayoutX(250);
                            btnTemp.setLayoutY(30);
                            btnTemp.setGraphic(iTemp);
                            btnTemp.setStyle("-fx-background-color: transparent");

                            Button btnLogo = new Button();

                            Image logo;
                            try {
                                logo = new Image(HelloApplication.class.getResource("hammer.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iLogo = new ImageView(logo);
                            iLogo.setFitWidth(50);
                            iLogo.setFitHeight(50);

                            btnLogo.setGraphic(iLogo);
                            btnLogo.setStyle("-fx-background-color: transparent");
                            btnLogo.setLayoutX(1170);
                            btnLogo.setLayoutY(20);

                            hboxM1.setSpacing(50);
                            hboxM1.setPadding(new Insets(20,300,60,1090));
                            hboxM1.setId("hbox");

                            hboxM1.setLayoutX(10);
                            hboxM1.setLayoutY(10);

                            sceneM1.getStylesheets().add(HelloApplication.class.getResource("styleM1.css").toExternalForm());
                            groupM1.getChildren().addAll(backButton,searchField,addClient,delClient,regClient,tableView,hboxM1,btnLogo,btnProfil,btnTemp,btnContract,btnTelephone,btnPeople,btnHome);

                            stage.setScene(sceneM1);
                            stage.setMaximized(true);
                            stage.show();
                        }
                    });
                    Button m3 = new Button("أرشيف المكتب");
                    m3.setId("btnRapid");
                    m3.setLayoutX(50);
                    m3.setLayoutY(330);
//تقويم*********************-------------------------------------------------------------------------------********************
                    m3.setOnAction(new EventHandler<ActionEvent>() {

                        private GridPane calendarPane;
                        private Label yearLabel;
                        private int currentYear;
                        private int currentMonth;

                        @Override
                        public void handle(ActionEvent actionEvent) {

                            Stage primaryStage = new Stage();
                            currentYear = YearMonth.now().getYear();
                            currentMonth = YearMonth.now().getMonthValue();

                            // Create calendar pane
                            calendarPane = createCalendarPane(currentYear, currentMonth);

                            // Create navigation buttons
                            Button prevYearButton = new Button("<<");
                            Button nextYearButton = new Button(">>");
                            Button prevMonthButton = new Button("<");
                            Button nextMonthButton = new Button(">");

                            // Add button event handlers
                            prevYearButton.setOnAction(event -> {
                                currentYear--;
                                yearLabel.setText(Integer.toString(currentYear));
                                calendarPane = createCalendarPane(currentYear, currentMonth);
                                updateScene(primaryStage);
                            });

                            nextYearButton.setOnAction(event -> {
                                currentYear++;
                                yearLabel.setText(Integer.toString(currentYear));
                                calendarPane = createCalendarPane(currentYear, currentMonth);
                                updateScene(primaryStage);
                            });

                            prevMonthButton.setOnAction(event -> {
                                if (currentMonth == 1) {
                                    currentMonth = 12;
                                    currentYear--;
                                } else {
                                    currentMonth--;
                                }
                                calendarPane = createCalendarPane(currentYear, currentMonth);
                                updateScene(primaryStage);
                            });

                            nextMonthButton.setOnAction(event -> {
                                if (currentMonth == 12) {
                                    currentMonth = 1;
                                    currentYear++;
                                } else {
                                    currentMonth++;
                                }
                                calendarPane = createCalendarPane(currentYear, currentMonth);
                                updateScene(primaryStage);
                            });

                            // Create year label
                            yearLabel = new Label(Integer.toString(currentYear));
                            yearLabel.setStyle("-fx-font-weight: bold;");

                            // Create button box
                            HBox buttonBox = new HBox(10);
                            buttonBox.setPadding(new Insets(10));
                            buttonBox.getChildren().addAll(prevYearButton, prevMonthButton, yearLabel, nextMonthButton, nextYearButton);

                            // Create scene
                            Scene scene = new Scene(new VBox(buttonBox, calendarPane), 800, 600);
                            primaryStage.setScene(scene);
                            primaryStage.setTitle("Calendar");
                            primaryStage.show();
                        }

                        private void updateScene(Stage primaryStage) {
                            Scene scene = primaryStage.getScene();
                            VBox root = (VBox) scene.getRoot();
                            root.getChildren().set(1, calendarPane);
                        }

                        private GridPane createCalendarPane(int year, int month) {
                            GridPane calendarPane = new GridPane();
                            calendarPane.setHgap(5);
                            calendarPane.setVgap(5);
                            calendarPane.setPadding(new Insets(10));

                            // Add year and month labels
                            Label monthLabel = new Label(YearMonth.of(year, month).getMonth().toString());
                            monthLabel.setStyle("-fx-font-weight: bold;");
                            calendarPane.add(monthLabel, 0, 0, 7, 1);
                            GridPane.setHalignment(monthLabel, HPos.CENTER);

                            // Add weekday labels
                            String[] weekdays = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat","Sun"};

                            for (int i = 0; i < weekdays.length; i++) {
                                Label weekdayLabel = new Label(weekdays[i]);
                                weekdayLabel.setStyle("-fx-font-weight: bold;");
                                calendarPane.add(weekdayLabel, i, 1);
                                GridPane.setHalignment(weekdayLabel, HPos.CENTER);
                            }

                            // Get first day of month
                            LocalDate firstDayOfMonth = YearMonth.of(year, month).atDay(1);

                            // Compute number of days in month
                            int daysInMonth = YearMonth.of(year, month).lengthOfMonth();

                            // Compute number of days to display from previous month
                            int daysFromPrevMonth = firstDayOfMonth.getDayOfWeek().getValue() - 1;

                            // Compute number of days to display from next month
                            int daysFromNextMonth = 7 - ((daysInMonth + daysFromPrevMonth) % 7);

                            // Display days from previous month
                            YearMonth prevMonth = yearMonthMinusMonths(year, month, 1);
                            for (int i = 1; i <= daysFromPrevMonth; i++) {
                                int day = YearMonth.of(prevMonth.getYear(), prevMonth.getMonthValue()).lengthOfMonth() - daysFromPrevMonth + i;
                                Label dayLabel = new Label(Integer.toString(day));
                                dayLabel.setStyle("-fx-text-fill: gray;");
                                calendarPane.add(dayLabel, i - 1, 2);
                                GridPane.setHalignment(dayLabel, HPos.CENTER);
                            }

                            // Display days from current month
                            for (int i = 1; i <= daysInMonth; i++) {
                                int day = i;
                                Label dayLabel = new Label(Integer.toString(day));
                                calendarPane.add(dayLabel, (i - 1 + daysFromPrevMonth) % 7, (i - 1 + daysFromPrevMonth) / 7 + 2);
                                GridPane.setHalignment(dayLabel, HPos.CENTER);
                            }

                            // Display days from next month
                            YearMonth nextMonth = yearMonthPlusMonths(year, month, 1);
                            for (int i = 1; i <= daysFromNextMonth; i++) {
                                Label dayLabel = new Label(Integer.toString(i));
                                dayLabel.setStyle("-fx-text-fill: gray;");
                                calendarPane.add(dayLabel, (daysInMonth + daysFromPrevMonth + i - 1) % 7, (daysInMonth + daysFromPrevMonth + i - 1) / 7 + 2);
                                GridPane.setHalignment(dayLabel, HPos.CENTER);
                            }

                            return calendarPane;
                        }

                        private YearMonth yearMonthMinusMonths(int year, int month, int months) {
                            return YearMonth.of(year, month).minusMonths(months);
                        }

                        private YearMonth yearMonthPlusMonths(int year, int month, int months) {
                            return YearMonth.of(year, month).plusMonths(months);
                        }
                    });

                    Button m4 = new Button("العرائض");
                    m4.setId("btnRapid");
                    m4.setLayoutX(800);
                    m4.setLayoutY(400);
                    m4.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText("This is an information message.");
                            alert.setContentText("You can use alerts to display notifications.");

                            alert.showAndWait();
                        }
                    });
                    Button m5 = new Button("اضافة قضية");
                    m5.setId("btnRapid");
                    m5.setLayoutX(550);
                    m5.setLayoutY(400);
                    Button k = new Button("تاجيل القضايا");
                    k.setId("btnRapid");
                    k.setLayoutX(300);
                    k.setLayoutY(400);
                    Button k11 = new Button("منطوق الأحكام");
                    k11.setId("btnRapid");
                    k11.setLayoutX(50);
                    k11.setLayoutY(400);
                    Button k2 = new Button("الإشعارات");
                    k2.setId("btnRapid");
                    k2.setLayoutX(300);
                    k2.setLayoutY(470);
                    Button k3 = new Button("الدستور");
                    k3.setId("btnRapid");
                    k3.setLayoutX(550);
                    k3.setLayoutY(470);

                    premaire.getChildren().addAll(hbox,vbox,qurane,qurane1,m100,m11,m2,m3,m4,m5,k,k11,k2,k3,btnLogo,btnProfil,btnTemp,btnContract,btnTelephone,btnPeople,btnHome);

                    scene3.getStylesheets().add(HelloApplication.class.getResource("style.css").toExternalForm());

                    stage.setMaximized(true);
                    stage.setScene(scene3);
                    stage.show();
                }
            }
        });

        BorderPane.setAlignment(vBoxBottom,Pos.BOTTOM_CENTER);
        borderPane.setBottom(vBoxBottom);

        Label forgetPass = new Label("نسيت كلمة السر");
        forgetPass.setId("forgetPass");
        forgetPass.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("852");
            }
        });

        GridPane gridPaneOR = new GridPane();

        Line line = new Line();
        line.setId("line");
        line.setStartX(0.0f);
        line.setEndX(300.0f);
        gridPaneOR.add(line,0,0);

        Label or = new Label("أو");
        or.setId("or");
        gridPaneOR.add(or,1,0);

        Line line1 = new Line();
        line1.setId("line");
        line1.setStartX(0.0f);
        line1.setEndX(300.0f);
        gridPaneOR.add(line1,2,0);

        gridPaneOR.setAlignment(Pos.CENTER);
        gridPaneOR.setVgap(5);
        gridPaneOR.setHgap(5);

        Button btnCreer = new Button("إنشاء حساب");
        btnCreer.setId("btnCreer");

        btnCreer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Pane group = new Pane();
                group.setId("borderPane");

                Image log1;
                try {
                    log1 = new Image(HelloApplication.class.getResource("back.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iPas1 = new ImageView(log1);
                iPas1.setFitWidth(33);
                iPas1.setFitHeight(33);

                Button btn = new Button();
                btn.setId("back");
                btn.setGraphic(iPas1);
                btn.setLayoutX(5);
                btn.setLayoutY(5);

                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        stage.setScene(scene);
                        stage.show();
                    }
                });

                btn.setStyle("-fx-background-color: transparent");

                Image add;
                try {
                    add = new Image(HelloApplication.class.getResource("addd.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iAdd = new ImageView(add);
                iAdd.setFitWidth(140);
                iAdd.setFitHeight(140);

                Button btnAdd = new Button();
                btnAdd.setGraphic(iAdd);
                btnAdd.setLayoutX(330);
                btnAdd.setLayoutY(30);

                btnAdd.setStyle("-fx-background-color: transparent");

                Image name;
                try {
                    name = new Image(HelloApplication.class.getResource("user_1.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iName = new ImageView(name);
                iName.setFitWidth(25);
                iName.setFitHeight(25);

                Button btnName = new Button();
                btnName.setGraphic(iName);
                btnName.setLayoutX(50);
                btnName.setLayoutY(240);

                btnName.setStyle("-fx-background-color: transparent");

                TextField txtName = new TextField();
                txtName.setId("txt");
                txtName.setPromptText("الإسم");
                txtName.setPrefWidth(250);
                txtName.setFocusTraversable(false);
                txtName.setLayoutX(100);
                txtName.setLayoutY(240);

                Image familly;
                try {
                    familly = new Image(HelloApplication.class.getResource("group.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iFamilly = new ImageView(familly);
                iFamilly.setFitWidth(35);
                iFamilly.setFitHeight(35);

                Button btnFamilly = new Button();
                btnFamilly.setGraphic(iFamilly);
                btnFamilly.setLayoutX(445);
                btnFamilly.setLayoutY(240);

                btnFamilly.setStyle("-fx-background-color: transparent");

                TextField txtFamilly = new TextField();
                txtFamilly.setId("txt");
                txtFamilly.setPromptText("اللقب");
                txtFamilly.setPrefWidth(250);
                txtFamilly.setLayoutX(500);
                txtFamilly.setFocusTraversable(false);
                txtFamilly.setLayoutY(240);

                Image email;
                try {
                    email = new Image(HelloApplication.class.getResource("message.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iEmail = new ImageView(email);
                iEmail.setFitWidth(32);
                iEmail.setFitHeight(32);

                Button btnEmail = new Button();
                btnEmail.setGraphic(iEmail);
                btnEmail.setLayoutX(47);
                btnEmail.setLayoutY(280);

                btnEmail.setStyle("-fx-background-color: transparent");

                TextField txtEmail = new TextField();
                txtEmail.setId("txt");
                txtEmail.setPromptText("الإيمايل");
                txtEmail.setPrefWidth(250);
                txtEmail.setFocusTraversable(false);
                txtEmail.setLayoutX(100);
                txtEmail.setLayoutY(280);

                Image tel;
                try {
                    tel = new Image(HelloApplication.class.getResource("calling.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iTel = new ImageView(tel);
                iTel.setFitWidth(25);
                iTel.setFitHeight(25);

                Button btnTel= new Button();
                btnTel.setGraphic(iTel);
                btnTel.setLayoutX(450);
                btnTel.setLayoutY(280);

                btnTel.setStyle("-fx-background-color: transparent");

                TextField txtTel = new TextField();
                txtTel.setId("txt");
                txtTel.setPromptText("رقم الهاتف");
                txtTel.setPrefWidth(250);
                txtTel.setFocusTraversable(false);
                txtTel.setLayoutX(500);
                txtTel.setLayoutY(280);

                Image pass;
                try {
                    pass = new Image(HelloApplication.class.getResource("mot_de_passe.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iPass = new ImageView(pass);
                iPass.setFitWidth(25);
                iPass.setFitHeight(25);

                Button btnPass = new Button();
                btnPass.setGraphic(iPass);
                btnPass.setLayoutX(50);
                btnPass.setLayoutY(320);

                btnPass.setStyle("-fx-background-color: transparent");

                TextField txtPass = new TextField();
                txtPass.setId("txt");
                txtPass.setPromptText("كلمة السر");
                txtPass.setPrefWidth(250);
                txtPass.setFocusTraversable(false);
                txtPass.setLayoutX(100);
                txtPass.setLayoutY(320);

                Image coPass;
                try {
                    coPass = new Image(HelloApplication.class.getResource("mot_de_passe.png").openStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ImageView iCoPass = new ImageView(coPass);
                iCoPass.setFitWidth(25);
                iCoPass.setFitHeight(25);

                Button btnCoPass = new Button();
                btnCoPass.setGraphic(iCoPass);
                btnCoPass.setLayoutX(450);
                btnCoPass.setLayoutY(320);

                btnCoPass.setStyle("-fx-background-color: transparent");

                TextField txtCoPass = new TextField();
                txtCoPass.setId("txt");
                txtCoPass.setPromptText("تأكيد كلمة السر");
                txtCoPass.setPrefWidth(250);
                txtCoPass.setFocusTraversable(false);
                txtCoPass.setLayoutX(500);
                txtCoPass.setLayoutY(320);

                Label backLogin = new Label("لدي حساب بالفعل");
                backLogin.setId("label");
                //backLogin.setPrefWidth(250);
                backLogin.setLayoutX(380);
                backLogin.setLayoutY(550);
                backLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        stage.setScene(scene);
                        stage.show();
                    }
                });

                Line line = new Line();
                line.setId("line");
                line.setStartX(0.0f);
                line.setEndX(300.0f);
                line.setLayoutX(111);
                line.setLayoutY(498);

                Label or = new Label("أو");
                or.setId("or");
                or.setLayoutX(420);
                or.setLayoutY(491);

                Line line1 = new Line();
                line1.setId("line");
                line1.setStartX(0.0f);
                line1.setEndX(300.0f);
                line1.setLayoutX(441);
                line1.setLayoutY(498);

                ToggleGroup group1 = new ToggleGroup();

                RadioButton option1 = new RadioButton("أنثى");
                option1.setToggleGroup(group1);

                RadioButton option2 = new RadioButton("ذكر");
                option2.setToggleGroup(group1);

                RadioButton selectedOption1 = (RadioButton) group1.getSelectedToggle();
                if (selectedOption1 != null) {
                    System.out.println("Selected option: " + selectedOption1.getText());
                }

                Label mw = new Label("الجنس :");
                mw.setId("mw");
                mw.setLayoutX(480);
                mw.setLayoutY(390);

                option1.setLayoutX(350);
                option1.setLayoutY(390);
                option1.setId("option");
                option2.setLayoutX(420);
                option2.setLayoutY(390);
                option2.setSelected(true);
                option2.setId("option");

                Button conf = new Button("تأكيد");
                conf.setId("confir");
                conf.setLayoutX(350);
                conf.setLayoutY(440);

                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), 5)),
                        new KeyFrame(Duration.seconds(0.125),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.25),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.375),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.5),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.625),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.75),
                                new javafx.animation.KeyValue(txtName.translateXProperty(), 0))
                );

                Timeline timeline1 = new Timeline(
                        new KeyFrame(Duration.seconds(0),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), 5)),
                        new KeyFrame(Duration.seconds(0.125),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.25),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.375),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.5),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.625),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.75),
                                new javafx.animation.KeyValue(txtFamilly.translateXProperty(), 0))
                );

                Timeline timeline2 = new Timeline(
                        new KeyFrame(Duration.seconds(0),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), 5)),
                        new KeyFrame(Duration.seconds(0.125),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.25),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.375),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.5),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.625),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.75),
                                new javafx.animation.KeyValue(txtEmail.translateXProperty(), 0))
                );

                Timeline timeline3 = new Timeline(
                        new KeyFrame(Duration.seconds(0),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), 5)),
                        new KeyFrame(Duration.seconds(0.125),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.25),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.375),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.5),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.625),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.75),
                                new javafx.animation.KeyValue(txtTel.translateXProperty(), 0))
                );

                Timeline timeline4 = new Timeline(
                        new KeyFrame(Duration.seconds(0),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), 5)),
                        new KeyFrame(Duration.seconds(0.125),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.25),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.375),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.5),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.625),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.75),
                                new javafx.animation.KeyValue(txtPass.translateXProperty(), 0))
                );

                Timeline timeline5 = new Timeline(
                        new KeyFrame(Duration.seconds(0),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), 5)),
                        new KeyFrame(Duration.seconds(0.125),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.25),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.375),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.5),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), +10)),
                        new KeyFrame(Duration.seconds(0.625),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), -10)),
                        new KeyFrame(Duration.seconds(0.75),
                                new javafx.animation.KeyValue(txtCoPass.translateXProperty(), 0))
                );

//---Button----------------------------------------------------------------------------------------------

                VBox vBoxBottom = new VBox(20);
                Button btnLogin = new Button("Login");
                btnLogin.setId("btnLogin");

                conf.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if (txtName.getText().isEmpty() ){
                            txtName.setStyle("-fx-border-color: red");
                            timeline.play();

                        }
                        else{
                            txtName.setStyle("-fx-border-color: white");
                        }

                        if (txtFamilly.getText().isEmpty() ){
                            txtFamilly.setStyle("-fx-border-color: red");
                            timeline1.play();

                        }
                        else{
                            txtFamilly.setStyle("-fx-border-color: white");
                        }

                        if (txtEmail.getText().isEmpty() ){
                            txtEmail.setStyle("-fx-border-color: red");
                            timeline2.play();

                        }
                        else{
                            txtEmail.setStyle("-fx-border-color: white");
                        }

                        if (txtTel.getText().isEmpty() ){
                            txtTel.setStyle("-fx-border-color: red");
                            timeline3.play();

                        }
                        else{
                            txtTel.setStyle("-fx-border-color: white");
                        }

                        if (txtPass.getText().isEmpty() ){
                            txtPass.setStyle("-fx-border-color: red");
                            timeline4.play();

                        }
                        else{
                            txtPass.setStyle("-fx-border-color: white");
                        }

                        if (txtCoPass.getText().isEmpty() ){
                            txtCoPass.setStyle("-fx-border-color: red");
                            timeline5.play();

                        }
                        else{
                            txtCoPass.setStyle("-fx-border-color: white");
                        }
                    }
                });
                group.getChildren().addAll(mw,option1,option2,txtName,txtFamilly,txtEmail,txtTel,txtPass,txtCoPass,line,line1,or,backLogin,conf,btnName,btnFamilly,btnEmail,btnTel,btnPass,btnCoPass,btnAdd,btn);

                Scene sceneCree = new Scene(group,850, 600);

                sceneCree.getStylesheets().add(HelloApplication.class.getResource("application.css").toExternalForm());
                stage.setScene(sceneCree);

                stage.show();
            }
        });
        
        vBoxBottom.getChildren().addAll(btnLogin,forgetPass,gridPaneOR,btnCreer);
        vBoxBottom.setPadding(new Insets(0,0,50,0));
        vBoxBottom.setAlignment(Pos.BOTTOM_CENTER);

        String css = HelloApplication.class.getResource("l.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}