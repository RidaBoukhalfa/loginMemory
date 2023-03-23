package memory;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;


public class HelloApplication extends Application {

    public class Person {
        private String firstName;
        private String lastName;
        private int id;
        private String lastFather;
        private String khasem;
        private String classes;
        private String sujet;
        private Date date;
        private Date retard;
        private String couse;
        private String liew;




        public Person(String firstName, String lastName, int id,String lastFather,String khasem,String classes,String sujet,Date date,Date retard,String couse,String liew) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.lastFather= lastFather;
            this.khasem= khasem;
            this.classes= classes;
            this.sujet= sujet;
            this.date=date;
            this.retard=retard;
            this.couse=couse;
            this.liew=liew;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getId() {
            return id;
        }

        public String getKhasem(){
            return lastFather;
        }

        public String getClasses(){
            return lastFather;
        }

//        public String getSujet(){
//            return l;
//        }

        public String getCouse(){
            return couse;
        }

        public String getLiew(){
            return liew;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setid(int id) {
            this.id = id;
        }
    }


    private boolean isLiked = false;

    @Override
    public void start(Stage stage) throws IOException {
    	
    	BorderPane borderPane = new BorderPane();
    	borderPane.setId("borderPane");

    	Scene scene = new Scene(borderPane, 850, 600);

        stage.getIcons().add(new Image(HelloApplication.class.getResource("hammer.png").openStream()));
        stage.setTitle("Facelawyer");
//--------Label of Login------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------

        VBox vBox = new VBox(20);
        HBox hBox = new HBox(20);
        GridPane gridPane = new GridPane();

//--------Label of Login------------------------------------------------------------------------------------------

        Image log = new Image(HelloApplication.class.getResource("log-in.png").openStream());
        ImageView iLog = new ImageView(log);
        iLog.setFitWidth(200);
        iLog.setFitHeight(175);
        borderPane.setTop(vBox);
        vBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(20,20,0,20));
        vBox.getChildren().add(iLog);

//----------------------------------------------------------------------------------------------------------

//--------TextFeild----------------------------------------------------------------------------------

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
//--------------------------------------------------------------------------------------------------------------------------------





//-------------------------------------------------------------------------------------------------
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

//---Button----------------------------------------------------------------------------------------------

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


//-----------befor login----------------------------------------------------------------------------------------------------------


                    Pane premaire = new Pane();
                    premaire.setId("group");
                    HBox hbox = new HBox();
                    Scene scene3 = new Scene(premaire, 1450, 790);

    //---------home image----------------------------------------------------------------------

        //-----select----------------------------------------------------------------------------
                    Image home;
                    try {
                        home = new Image(HelloApplication.class.getResource("home.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iHome = new ImageView(home);
                    iHome.setFitWidth(32);
                    iHome.setFitHeight(32);
        //------------------------------------------------------------------------------------------------------

        //-----no select----------------------------------------------------------------------------
                    Image home1;
                    try {
                        home1 = new Image(HelloApplication.class.getResource("home1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iHome1 = new ImageView(home1);
                    iHome1.setFitWidth(32);
                    iHome1.setFitHeight(32);

        //-----select----------------------------------------------------------------------------

                    Image people;
                    try {
                        people = new Image(HelloApplication.class.getResource("group1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                    ImageView iPeople = new ImageView(people);
                    iPeople.setFitWidth(32);
                    iPeople.setFitHeight(32);

        //-----no select----------------------------------------------------------------------------

                    Image people1;
                    try {
                        people1 = new Image(HelloApplication.class.getResource("group2.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iPeople1 = new ImageView(people1);
                    iPeople1.setFitWidth(32);
                    iPeople1.setFitHeight(32);


        //---------------------------------------------------------------------------------------------

        //-----select----------------------------------------------------------------------------

                    Image telephone;
                    try {
                        telephone = new Image(HelloApplication.class.getResource("phone1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                    ImageView iTelephone = new ImageView(telephone);
                    iTelephone.setFitWidth(32);
                    iTelephone.setFitHeight(32);

        //-----no select----------------------------------------------------------------------------

                    Image telephone1;
                    try {
                        telephone1 = new Image(HelloApplication.class.getResource("phone.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iTelephone1 = new ImageView(telephone1);
                    iTelephone1.setFitWidth(32);
                    iTelephone1.setFitHeight(32);


        //---------------------------------------------------------------------------------------------

        //-----select----------------------------------------------------------------------------

                    Image contract;
                    try {
                        contract = new Image(HelloApplication.class.getResource("contract1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iContract = new ImageView(contract);
                    iContract.setFitWidth(32);
                    iContract.setFitHeight(32);

        //-----no select----------------------------------------------------------------------------

                    Image contract1;
                    try {
                        contract1 = new Image(HelloApplication.class.getResource("contract.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iContract1 = new ImageView(contract1);
                    iContract1.setFitWidth(32);
                    iContract1.setFitHeight(32);

        //---------------------------------------------------------------------------------------------



        //---------------------------------------------------------------------------------------------

        //-----select----------------------------------------------------------------------------
                    Image temp;
                    try {
                        temp = new Image(HelloApplication.class.getResource("calendar.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iTemp = new ImageView(temp);
                    iTemp.setFitWidth(32);
                    iTemp.setFitHeight(32);
        //-----no select----------------------------------------------------------------------------
                    Image temp1;
                    try {
                        temp1 = new Image(HelloApplication.class.getResource("calendar1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView iTemp1 = new ImageView(temp1);
                    iTemp1.setFitWidth(32);
                    iTemp1.setFitHeight(32);
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------

                    Image profil;
                    try {
                        profil = new Image(HelloApplication.class.getResource("man1.png").openStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageView iProfil = new ImageView(profil);
                    iProfil.setFitWidth(50);
                    iProfil.setFitHeight(50);

        //---------------------------------------------------------------------------------------------------------------------------------------------------------------

                    ToggleButton btnHome = new ToggleButton();
                    btnHome.setGraphic(iHome);
                    btnHome.setSelected(true);
                    btnHome.setLayoutX(850);
                    btnHome.setLayoutY(30);
                    //btnHome.setGraphic(iHome);
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
                    //btnContract.setGraphic(iContract);
                    btnContract.setStyle("-fx-background-color: transparent");
                    btnContract.setId("btnPar");

                    ToggleButton btnTemp = new ToggleButton();
                    btnTemp.setGraphic(iTemp);
                    btnTemp.setLayoutX(250);
                    btnTemp.setLayoutY(30);
                    //btnTemp.setGraphic(iTemp);
                    btnTemp.setStyle("-fx-background-color: transparent");
                    btnTemp.setId("btnPar");

                    ToggleButton btnProfil = new ToggleButton();
                    btnProfil.setGraphic(iProfil);
                    btnProfil.setLayoutX(75);
                    btnProfil.setLayoutY(20);
                    //btnTemp.setGraphic(iTemp);
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


//---------------------------------------------------------------------------------------------

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

                    //____________________________________________________________________

                    //_____________________________________________________________

                    Button m100 = new Button("المواعيد");
                    m100.setId("btnRapid");
                    m100.setLayoutX(800);
                    m100.setLayoutY(330);
                    Button m11 = new Button("جهات الاتصال");
                    m11.setId("btnRapid");
                    m11.setLayoutX(550);
                    m11.setLayoutY(330);
                    Button m2 = new Button("إدارة الموكلين");
                    m2.setId("btnRapid");
                    m2.setLayoutX(300);
                    m2.setLayoutY(330);
                    m2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Group groupM1 = new Group();
                            HBox hboxM1 = new HBox();
                            Scene scene4 = new Scene(groupM1,1450, 790);

                            //Button add = new Button("")


                            //-----select----------------------------------------------------------------------------
                            Image home;
                            try {
                                home = new Image(HelloApplication.class.getResource("home.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iHome = new ImageView(home);
                            iHome.setFitWidth(32);
                            iHome.setFitHeight(32);
                            //------------------------------------------------------------------------------------------------------

                            //-----no select----------------------------------------------------------------------------
                            Image home1;
                            try {
                                home1 = new Image(HelloApplication.class.getResource("home1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iHome1 = new ImageView(home1);
                            iHome1.setFitWidth(32);
                            iHome1.setFitHeight(32);

                            //-----select----------------------------------------------------------------------------

                            Image people;
                            try {
                                people = new Image(HelloApplication.class.getResource("group1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }


                            ImageView iPeople = new ImageView(people);
                            iPeople.setFitWidth(32);
                            iPeople.setFitHeight(32);

                            //-----no select----------------------------------------------------------------------------

                            Image people1;
                            try {
                                people1 = new Image(HelloApplication.class.getResource("group2.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iPeople1 = new ImageView(people1);
                            iPeople1.setFitWidth(32);
                            iPeople1.setFitHeight(32);


                            //---------------------------------------------------------------------------------------------

                            //-----select----------------------------------------------------------------------------

                            Image telephone;
                            try {
                                telephone = new Image(HelloApplication.class.getResource("phone1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }


                            ImageView iTelephone = new ImageView(telephone);
                            iTelephone.setFitWidth(32);
                            iTelephone.setFitHeight(32);

                            //-----no select----------------------------------------------------------------------------

                            Image telephone1;
                            try {
                                telephone1 = new Image(HelloApplication.class.getResource("phone.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iTelephone1 = new ImageView(telephone1);
                            iTelephone1.setFitWidth(32);
                            iTelephone1.setFitHeight(32);


                            //---------------------------------------------------------------------------------------------

                            //-----select----------------------------------------------------------------------------

                            Image contract;
                            try {
                                contract = new Image(HelloApplication.class.getResource("contract1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iContract = new ImageView(contract);
                            iContract.setFitWidth(32);
                            iContract.setFitHeight(32);

                            //-----no select----------------------------------------------------------------------------

                            Image contract1;
                            try {
                                contract1 = new Image(HelloApplication.class.getResource("contract.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iContract1 = new ImageView(contract1);
                            iContract1.setFitWidth(32);
                            iContract1.setFitHeight(32);

                            //---------------------------------------------------------------------------------------------



                            //---------------------------------------------------------------------------------------------

                            //-----select----------------------------------------------------------------------------
                            Image temp;
                            try {
                                temp = new Image(HelloApplication.class.getResource("calendar.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iTemp = new ImageView(temp);
                            iTemp.setFitWidth(32);
                            iTemp.setFitHeight(32);
                            //-----no select----------------------------------------------------------------------------
                            Image temp1;
                            try {
                                temp1 = new Image(HelloApplication.class.getResource("calendar1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            ImageView iTemp1 = new ImageView(temp1);
                            iTemp1.setFitWidth(32);
                            iTemp1.setFitHeight(32);
                            //---------------------------------------------------------------------------------------------------------------------------------------------------------------

                            Image profil;
                            try {
                                profil = new Image(HelloApplication.class.getResource("man1.png").openStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            ImageView iProfil = new ImageView(profil);
                            iProfil.setFitWidth(50);
                            iProfil.setFitHeight(50);

                            //---------------------------------------------------------------------------------------------------------------------------------------------------------------

                            ToggleButton btnHome = new ToggleButton();
                            btnHome.setGraphic(iHome);
                            btnHome.setSelected(true);
                            btnHome.setLayoutX(850);
                            btnHome.setLayoutY(30);
                            //btnHome.setGraphic(iHome);
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
                            //btnContract.setGraphic(iContract);
                            btnContract.setStyle("-fx-background-color: transparent");
                            btnContract.setId("btnPar");

                            ToggleButton btnTemp = new ToggleButton();
                            btnTemp.setGraphic(iTemp);
                            btnTemp.setLayoutX(250);
                            btnTemp.setLayoutY(30);
                            //btnTemp.setGraphic(iTemp);
                            btnTemp.setStyle("-fx-background-color: transparent");
                            btnTemp.setId("btnPar");

                            ToggleButton btnProfil = new ToggleButton();
                            btnProfil.setGraphic(iProfil);
                            btnProfil.setLayoutX(75);
                            btnProfil.setLayoutY(20);
                            //btnTemp.setGraphic(iTemp);
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




//                            TableView<String> tableView = new TableView<>();
//
//
//                            TableView<Person> tableView = new TableView<Person>();
//                            TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
//                            firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
//                            TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
//                            lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
//                            TableColumn<Person, Integer> ageCol = new TableColumn<Person, Integer>("Age");
//                            ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
//                            tableView.getColumns().addAll(firstNameCol, lastNameCol, ageCol);
//
//                            ObservableList<Person> data = FXCollections.observableArrayList(
//                                    new Person("John", "Doe", 30),
//                                    new Person("Jane", "Doe", 25),
//                                    new Person("Bob", "Smith", 40)
//                            );
////
////                            tableView.setItems(data);
//
//                            // create the table columns
//                            TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
//                            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//
//                            TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
//                            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//
//                            TableColumn<Person, Integer> ageColumn = new TableColumn<>("Age");
//                            ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
//
//// create the table and add the columns
//                            TableView<Person> tableView = new TableView<>();
//                            tableView.getColumns().addAll(firstNameColumn, lastNameColumn, ageColumn);
//
//// create some sample data
////                            ObservableList<Person> data = FXCollections.observableArrayList(
////                                    new Person("John", "Doe", 25),
////                                    new Person("Jane", "Smith", 32),
////                                    new Person("Bob", "Johnson", 42)
////                            );
//
// //add the data to the table
//                            tableView.setItems(data);
//
//
//
//                            tableView.setLayoutX(30);
//                            tableView.setLayoutY(250);
//

//---------------------------------------------------------------------------------------------

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

                            scene4.getStylesheets().add(HelloApplication.class.getResource("styleM1.css").toExternalForm());
                            groupM1.getChildren().addAll(hboxM1,btnLogo,btnProfil,btnTemp,btnContract,btnTelephone,btnPeople,btnHome);

                            stage.setScene(scene4);
                            stage.setMaximized(true);
                            stage.show();
                        }
                    });
                    Button m3 = new Button("أرشيف المكتب");
                    m3.setId("btnRapid");
                    m3.setLayoutX(50);
                    m3.setLayoutY(330);
                    Button m4 = new Button("العرائض");
                    m4.setId("btnRapid");
                    m4.setLayoutX(800);
                    m4.setLayoutY(400);
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

//----------------------------------------------------------------------------------------------------------------

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


//--------------------------------------------------------------------------------------------------------------
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

//-------------------------------------------------------------------------------------------------------

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
//----------------------------------------------------------------------------------------------------------
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
//-------------------------------------------------------------------------------------------------------------
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
//----------------------------------------------------------------------------------------------------------------
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
//--------------------------------------------------------------------------------------------------------------------------
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
//---------------------------------------------------------------------------------------------------------

                Label backLogin = new Label("لدي حساب بالفعل");
                backLogin.setId("label");
                //backLogin.setPrefWidth(250);
                backLogin.setLayoutX(380);
                backLogin.setLayoutY(550);



                backLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {



                        //welcom.start(stage);

                        stage.setScene(scene);
                        stage.show();
                    }
                });

//----------------------------------------------------------------------------------------------------

                Line line = new Line();
                line.setId("line");
                line.setStartX(0.0f);
                line.setEndX(300.0f);
                //gridPaneOR.add(line,0,0);
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


                        if (!txtFamilly.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtName.getText().isEmpty() || !txtFamilly.getText().isEmpty() || !txtPass.getText().isEmpty() || !txtCoPass.getText().isEmpty() || !txtTel.getText().isEmpty()){


                                    Group root  = new Group();
                                    Image imag=new Image(getClass().getResourceAsStream("man.png"));
                                    ImageView imageview=new ImageView(imag);
                                    imageview.setLayoutX(30);
                                    imageview.setLayoutY(500);
                                    TranslateTransition trans=new TranslateTransition();
                                    trans.setNode(imageview);
                                    trans.setByY(-480);
                                    trans.setDuration(Duration.millis(1500));
                                    trans.play();

//		    imageview.setLayoutX(35);
//		    imageview.setLayoutY(20);
                                    imageview.setFitHeight(300);
                                    imageview.setFitWidth(300);
                                    imageview.setId("imageview");
                                    Button btn1=new Button(" اضغظ  هنا ");
                                    btn1.setFont(Font.font("Segoe print",FontWeight.EXTRA_BOLD,25));
                                    btn1.setLayoutX(500);
                                    btn1.setLayoutY(-50);

                                    btn1.setOnAction(e->{
                                        Group root2  = new Group();
                                        Scene sc2=new Scene(root2,500,500);
                                        VBox vbox = new VBox(20);
                                        DatePicker startDatePicker = new DatePicker();
                                        DatePicker endDatePicker = new DatePicker();
                                        startDatePicker.setValue(LocalDate.now());
                                        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
                                        vbox.getChildren().add(new Label("Start Date:"));
                                        vbox.getChildren().add(startDatePicker);
                                        vbox.getChildren().add(new Label("End Date:"));
                                        vbox.getChildren().add(endDatePicker);
                                        root2.getChildren().add(vbox)
                                        ;		           Stage stage2=new Stage();
                                        stage2.initModality(Modality.APPLICATION_MODAL);
                                        stage2.setScene(sc2);
                                        stage2.show();

                                    });
                                    TranslateTransition transbtn=new TranslateTransition();
                                    transbtn.setNode(btn1);
                                    transbtn.setByY(500);
                                    transbtn.setDuration(Duration.millis(1500));
                                    transbtn.play();
                                    btn1.getStyleClass().add("btn1");

                                    Label lb1=new Label("مرحبا");
                                    TranslateTransition translb1=new TranslateTransition();
                                    lb1.setLayoutX(900);
                                    lb1.setLayoutY(-20);
                                    translb1.setNode(lb1);
                                    translb1.setByX(-250);
                                    translb1.setDuration(Duration.millis(1500));
                                    translb1.play();

                                    lb1.getStyleClass().add("lb1");

                                    root.getChildren().addAll(btn1,imageview ,lb1);
                                    Scene scene7 = new Scene(root,1090,540,Color.WHITE);
                                    //scene.getStylesheets().add(getClass().getResource("zineb.css").toExternalForm());
                                    stage.setScene(scene7);
                                    //primaryStage.setFullScreen(true);
                                    stage.show();
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

//--------------------------------------------------------------------------------------------------------------------------------

        String css = HelloApplication.class.getResource("l.css").toExternalForm();
        scene.getStylesheets().add(css);




        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}