CREATE TABLE allModules(
    id INT PRIMARY KEY auto_increment,
    moduleName VARCHAR (100),
    active BIT
);

CREATE TABLE moduleProperties(
    id INT PRIMARY KEY auto_increment,
    sessionsPerDay INT DEFAULT (3),
    presentationsPerSession INT DEFAULT (5),
    newSentencesPerDay INT DEFAULT (1),
    actualDay INT DEFAULT (1),
    nextSession INT DEFAULT (1)
);

INSERT INTO allModules (moduleName, active) VALUES ('language polish', 'FALSE');
INSERT INTO moduleProperties (sessionsPerDay, presentationsPerSession,
                              newSentencesPerDay,actualDay)
                              VALUES (3,5,1,8);

