
create database ligue;
use ligue;


CREATE TABLE club(
    club_id INT NOT NULL AUTO_INCREMENT,
    club_name VARCHAR(250) NOT NULL,
    club_logo VARCHAR(250) NOT NULL,
    PRIMARY KEY (club_id)
);

CREATE TABLE rounds(
    round_id INT  NOT NULL AUTO_INCREMENT,
    begin_date DATE NOT NULL,
    end_date  DATE NOT NULL,
    PRIMARY KEY (round_id)
);

CREATE TABLE game(
    game_id INT NOT NULL AUTO_INCREMENT,
    game_date DATE NOT NULL,
    round_id INT NOT NULL,
    host_team_id int not NULL,
    visitor_team_id int not null,
    PRIMARY KEY (game_id),
    FOREIGN key (host_team_id) REFERENCES club (club_id),
    FOREIGN key (visitor_team_id) REFERENCES club (club_id),
    FOREIGN KEY (round_id) REFERENCES rounds (round_id)
);

CREATE TABLE player(
    player_id INT NOT NULL AUTO_INCREMENT,
    player_first_name VARCHAR(250) NOT NULL,
    player_last_name VARCHAR(250) NOT NULL,
    player_shirt_number INT NOT NULL,
    club_id INT NOT NULL,
    PRIMARY KEY (player_id),
    FOREIGN KEY (club_id) REFERENCES club (club_id)
);

CREATE TABLE play(
    play_id INT AUTO_INCREMENT,
    number_red_card INT,
    number_yalow_card INT,
    game_id INT NOT NULL,
    player_id INT NOT NULL,
    elimination_period INT,
    PRIMARY KEY (play_id),
    FOREIGN KEY (game_id) REFERENCES game(game_id),
    FOREIGN key (player_id) REFERENCES player(player_id)
);

CREATE TABLE sanction(
     sanction_id INT AUTO_INCREMENT,
     number_of_red_card INT,
     number_of_yellow_card INT,
     player_id INT NOT NULL,
     executed BOOLEAN,
     elimination_period INT,
     description VARCHAR(500),
     begin_date DATE,
     PRIMARY KEY (sanction_id),
     FOREIGN key (player_id) REFERENCES player(player_id)
);

CREATE TABLE referee(
    referee_id INT AUTO_INCREMENT,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    PRIMARY KEY (referee_id)
);

CREATE TABLE report(
    report_id INT AUTO_INCREMENT,
    referee_id INT NOT NULL,
    player_id INT NOT NULL,
    game_id INT NOT NULL,
    report_txt VARCHAR(500) NOT NULL,
    PRIMARY KEY (report_id),
    FOREIGN key (referee_id) REFERENCES referee(referee_id),
    FOREIGN key (player_id) REFERENCES player(player_id),
    FOREIGN key (game_id) REFERENCES game(game_id)
);

ALTER TABLE game ADD COLUMN  referee_id INT;
ALTER TABLE game ADD FOREIGN KEY (referee_id) REFERENCES referee(referee_id);


DESC player;
DESC club;
DESC game;
DESC rounds;
DESC play;
DESC sanction;