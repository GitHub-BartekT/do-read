CREATE TABLE all_Modules(
    id INT PRIMARY KEY auto_increment,
    module_Name VARCHAR (100),
    active BIT
);

CREATE TABLE module_Properties(
    id INT PRIMARY KEY auto_increment,
    sessions_Per_Day INT DEFAULT (3),
    presentations_Per_Session INT DEFAULT (5),
    new_Sentences_Per_Day INT DEFAULT (1),
    actual_Day INT DEFAULT (1),
    next_Session INT DEFAULT (1)
);

INSERT INTO all_Modules (module_Name, active) VALUES ('language polish', 'TRUE');
INSERT INTO all_Modules (module_Name, active) VALUES ('language english', 'FALSE');
INSERT INTO module_Properties (sessions_Per_Day, presentations_Per_Session,
                              new_Sentences_Per_Day,actual_Day)
                              VALUES (3,5,1,8);
INSERT INTO module_Properties (sessions_Per_Day, presentations_Per_Session,
                               new_Sentences_Per_Day,actual_Day, next_Session)
VALUES (2,3,1,5,1);

