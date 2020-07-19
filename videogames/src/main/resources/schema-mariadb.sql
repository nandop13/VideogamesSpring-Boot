/**
 * Author:  fernando.penaranda
 * Created: 05-jul-2020
 */

/** First clean videogame table*/
drop table if exists videogame;

/** Create videodame table SQL*/
create table videogame(
    id int primary key auto_increment,
    videogame_name varchar(200) not null,
    description varchar(3000),
    url_image varchar(500)
);


/** Populate videogames SQL*/
insert into videogame (id, videogame_name, description, url_image) values
(1,'Gears of War' , 'The series focuses on the conflict between humanity, the subterranean reptilian hominids known as the Locust Horde, and their mutated counterparts, the Lambent.' , 'https://vignette.wikia.nocookie.net/gearsofwar/images/8/8d/Gears_of_War_3_Portada.png/revision/latest?cb=20160708053351&path-prefix=es'),
(2,'Crash Bandicoot' , 'The games are mostly set on the fictitious Wumpa Islands, an archipelago situated to the south of Australia where humans and mutant animals co-exist, although other locations are common. The main games in the series are largely platformers, but several are spin-offs in different genres.' , 'https://images-na.ssl-images-amazon.com/images/I/71fIrwKQ5IL._AC_SY879_.jpg'),
(3,'Dragon Ball Z' , 'The series follows the adventures of Goku as he trains in martial arts and explores the world in search of the seven wish-granting orbs known as the Dragon Balls.' , 'https://images-na.ssl-images-amazon.com/images/I/910GBdyEQpL._SL1500_.jpg'),
(4,'Bloody Roar' , 'Is a series of fighting games created by Hudson Soft, and developed together with Eighting. The game theme incorporated anthropomorphism, where the player has the ability to transform into a half-human, half-animal creature known as a Zoanthrope.' , 'https://vignette.wikia.nocookie.net/bloodyroar/images/3/39/Caratula_Bloody_Roar_Extreme.png/revision/latest/scale-to-width-down/340?cb=20110710190938&path-prefix=es'),
(5,'GTA San Andreas' , 'The game features references to many real-life elements of the world, such as its cities, regions, and landmarks, with its plot heavily based on several real-life events in Los Angeles in the early 1990s, including the rivalry between real-life street gangs.' , 'https://vignette.wikia.nocookie.net/es.gta/images/c/c2/Grand_Theft_Auto_San_Andreas.JPG/revision/latest?cb=20161127211015'),
(6,'HALO' , 'The original trilogy centers on an interstellar war between humanity and an alliance of aliens known as the Covenant. The Covenant, led by their religious leaders called the Prophets, worship an ancient civilization known as the Forerunners, who perished while defeating the parasitic Flood.' , 'https://as.com/meristation/imagenes/2019/06/10/game_cover/645891351560155590.jpg'),
(7,'PES 5' , 'Is a football video game developed and produced by Konami as part of the Pro Evolution Soccer series. With featuring Arsenal and Chelsea it is the first release of the series which offered fully licensed clubs from the Premier League, which is one of the 3 unlicensed leagues of the game.' , 'https://www.auctionit.org.uk/images/pro-evolution-soccer-5-xbox-front-cover.jpg'),
(8,'Burnout 3: Takedown' , 'Is characterised by fast-paced arcade racing. A staple of the series is the use of boost, earned through risky driving, to rapidly increase a car speed. The central mechanic introduced in Burnout 3 is Takedowns, which allow players to slam their opponents until they crash. ' , 'https://www.retroplace.com/pics/ps2/packshots/70930--burnout-3-takedown.png');

/** First clean provider table*/
drop table if exists provider;

/** Create provider table SQL*/
create table provider(
    id int primary key auto_increment,
    provider_name varchar(200) not null,
    website varchar(500)
);

/** Populates the`provider table*/
insert into provider 
(id, provider_name, website) values
(1,'2K', 'https://www.2k.com/en-US/'),
(2,'Focus Home Interactive', 'https://www.focus-home.com/'),
(3,'EA Sports', 'https://www.ea.com/'),
(4,'505 GAMES', 'https://505games.com/');

/** alter videogame table */
alter table videogame
add column provider_id int,
add foreign key (provider_id) references provider(id);

/** update videogame table to set the provider key*/
update videogame set provider_id = 1 where id in (1,3);
update videogame set provider_id = 2 where id in (2,5);
update videogame set provider_id = 3 where id in (7,6);
update videogame set provider_id = 4 where id in (4,8);

/** set NOT NULL property to provider_id on videogames table*/
alter table videogame 
modify column provider_id int not null;