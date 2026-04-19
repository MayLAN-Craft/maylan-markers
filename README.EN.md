
## Maylan Markers

[RUSSIAN README](README.MD)

![plugin_icon](Icon_EasyBMSignMarkers.png)

The idea is simple - you put a sign in the game, and you can see it on your BlueMap.

This plugin is a fork of and old, no longer maintained solutions - [BlueMapSignMarkers](https://modrinth.com/plugin/bluemapsignmarkers) and [Easy BlueMap Sign Markers](https://github.com/deimiczny/easy-bmapmarkers) - introducing some simplification and quality-of-life tweaks, as compared to the original source. 
The goal was to make it usable in as little steps as possible, and as easy as possible for players to understand how to use it.

Compatible with Paper 26.1.2+

## Setup
You need to have **BlueMap** installed on your server. The plugin depends on it.
If you already have **BlueMap**, put the jar file into `plugins` folder on your server... and that's it!

## How to use
Place any sign in the game. Fill the sign as follows:

- **1st line**: `[marker_icon_name]` (please see [Marker names](#marker-names) for available name tags)
- **2nd line:** text
- **3rd line:** text
- **4th line:** text

**Note:** after adding the marker, the first line will change to `> marker <` in order to indicate that the given sign acts as marker. The intention here is to ensure players will not remove markers by accident.

First line **MUST** be filled. If the 1st line does not contain a valid name, but still the brackets `[` and `]` are being used - the fallback value will be assigned - `[map]` - and marker will be created anyway.
From the following 3 text-oriented lines, at least one must be non-empty. If all are empty, marker will not be created. Assumption here is, that the marker **needs** a description.

## Example
Below example will create marker on your map with `star` icon assigned.

First, you build the sign

![sign1](example1.png)

After you complete it, the first line will switch to `> marker <`. This indicates, that placing the marker was successful.

![sign2](example2.png)

After a while, you will see the marker on your BlueMap

![sign3](example3.png)

And when you click it - the popup containing your sign description will appear

![sign4](example4.png)

## Marker names
These are the names that are available for the markers, plus the corresponding icons. Just use any of the values between brackets - `[` and `]`, e.g. `[bank]` - to place the marker on the **BlueMap**.
It does not matter if you use lowercase or uppercase. The plugin will handle it.

| Name         |                                Icon                                 | Note           | Name        |                                                               Icon                                                                | Note           |
|--------------|:-------------------------------------------------------------------:|----------------|-------------|:---------------------------------------------------------------------------------------------------------------------------------:|----------------|
| anchor       |       ![anchor](src/main/resources/markers/dynmap/anchor.png)       |                | key         |                                         ![key](src/main/resources/markers/dynmap/key.png)                                         |                |
| bank         |         ![bank](src/main/resources/markers/dynmap/bank.png)         |                | king        |                                        ![king](src/main/resources/markers/dynmap/king.png)                                        |                |
| basket       |       ![basket](src/main/resources/markers/dynmap/basket.png)       |                | left        |                                        ![left](src/main/resources/markers/dynmap/left.png)                                        |                |
| bed          |          ![bed](src/main/resources/markers/dynmap/bed.png)          |                | lightbulb   |                                   ![lightbulb](src/main/resources/markers/dynmap/lightbulb.png)                                   |                |
| beer         |         ![beer](src/main/resources/markers/dynmap/beer.png)         |                | lighthouse  |                                  ![lighthouse](src/main/resources/markers/dynmap/lighthouse.png)                                  |                |
| bighouse     |     ![bighouse](src/main/resources/markers/dynmap/bighouse.png)     |                | lock        |                                        ![lock](src/main/resources/markers/dynmap/lock.png)                                        |                |
| blueflag     |     ![blueflag](src/main/resources/markers/dynmap/blueflag.png)     |                | **map**         |                                         ![map](src/main/resources/markers/dynmap/map.png)                                         | Fallback value |
| bomb         |         ![bomb](src/main/resources/markers/dynmap/bomb.png)         |                | minecart    |                                    ![minecart](src/main/resources/markers/dynmap/minecart.png)                                    |                |
| bookshelf    |    ![bookshelf](src/main/resources/markers/dynmap/bookshelf.png)    |                | offlineuser |                                 ![offlineuser](src/main/resources/markers/dynmap/offlineuser.png)                                 |                |
| bricks       |       ![bricks](src/main/resources/markers/dynmap/bricks.png)       |                | orangeflag  |                                  ![orangeflag](src/main/resources/markers/dynmap/orangeflag.png)                                  |                |
| bronzemedal  |  ![bronzemedal](src/main/resources/markers/dynmap/bronzemedal.png)  |                | pinkflag    |                                    ![pinkflag](src/main/resources/markers/dynmap/pinkflag.png)                                    |                |
| bronzestar   |   ![bronzestar](src/main/resources/markers/dynmap/bronzestar.png)   |                | pirateflag  |                                  ![pirateflag](src/main/resources/markers/dynmap/pirateflag.png)                                  |                |
| building     |     ![building](src/main/resources/markers/dynmap/building.png)     |                | pointdown   |                                   ![pointdown](src/main/resources/markers/dynmap/pointdown.png)                                   |                |
| cake         |         ![cake](src/main/resources/markers/dynmap/cake.png)         |                | pointleft   |                                   ![pointleft](src/main/resources/markers/dynmap/pointleft.png)                                   |                |
| camera       |       ![camera](src/main/resources/markers/dynmap/camera.png)       |                | pointright  |                                  ![pointright](src/main/resources/markers/dynmap/pointright.png)                                  |                |
| cart         |         ![cart](src/main/resources/markers/dynmap/cart.png)         |                | pointup     |                                     ![pointup](src/main/resources/markers/dynmap/pointup.png)                                     |                |
| caution      |      ![caution](src/main/resources/markers/dynmap/caution.png)      |                | portal      |                                      ![portal](src/main/resources/markers/dynmap/portal.png)                                      |                |
| chest        |        ![chest](src/main/resources/markers/dynmap/chest.png)        |                | purpleflag  |                                  ![purpleflag](src/main/resources/markers/dynmap/purpleflag.png)                                  |                |
| church       |       ![church](src/main/resources/markers/dynmap/church.png)       |                | queen       |                                       ![queen](src/main/resources/markers/dynmap/queen.png)                                       |                |
| coins        |        ![coins](src/main/resources/markers/dynmap/coins.png)        |                | redflag     |                                     ![redflag](src/main/resources/markers/dynmap/redflag.png)                                     |                |
| comment      |      ![comment](src/main/resources/markers/dynmap/comment.png)      |                | right       |                                       ![right](src/main/resources/markers/dynmap/right.png)                                       |                |
| compass      |      ![compass](src/main/resources/markers/dynmap/compass.png)      |                | ruby        |                                        ![ruby](src/main/resources/markers/dynmap/ruby.png)                                        |                |
| construction | ![construction](src/main/resources/markers/dynmap/construction.png) |                | scales      |                                      ![scales](src/main/resources/markers/dynmap/scales.png)                                      |                |
| cross        |        ![cross](src/main/resources/markers/dynmap/cross.png)        |                | shield      |                                      ![shield](src/main/resources/markers/dynmap/shield.png)                                      |                |
| cup          |          ![cup](src/main/resources/markers/dynmap/cup.png)          |                | sign        |                                        ![sign](src/main/resources/markers/dynmap/sign.png)                                        |                |
| cutlery      |      ![cutlery](src/main/resources/markers/dynmap/cutlery.png)      |                | silvermedal |                                 ![silvermedal](src/main/resources/markers/dynmap/silvermedal.png)                                 |                |
| diamond      |      ![diamond](src/main/resources/markers/dynmap/diamond.png)      |                | silverstar  |                                  ![silverstar](src/main/resources/markers/dynmap/silverstar.png)                                  |                |
| dog          |          ![dog](src/main/resources/markers/dynmap/dog.png)          |                 | skull       |                                       ![skull](src/main/resources/markers/dynmap/skull.png)                                       |                   |
| door         |         ![door](src/main/resources/markers/dynmap/door.png)         |                | star        |                                        ![star](src/main/resources/markers/dynmap/star.png)                                        |                |
| down         |         ![down](src/main/resources/markers/dynmap/down.png)         |                | sun         |                                         ![sun](src/main/resources/markers/dynmap/sun.png)                                         |                |
| drink        |        ![drink](src/main/resources/markers/dynmap/drink.png)        |                | temple      |                                      ![temple](src/main/resources/markers/dynmap/temple.png)                                      |                |
| exclamation  |  ![exclamation](src/main/resources/markers/dynmap/exclamation.png)  |                | theater     |                                     ![theater](src/main/resources/markers/dynmap/theater.png)                                     |                |
| factory      |      ![factory](src/main/resources/markers/dynmap/factory.png)      |                | tornado     |                                     ![tornado](src/main/resources/markers/dynmap/tornado.png)                                     |                |
| fire         |         ![fire](src/main/resources/markers/dynmap/fire.png)         |                | tower       |                                       ![tower](src/main/resources/markers/dynmap/tower.png)                                       |                |
| flower       |       ![flower](src/main/resources/markers/dynmap/flower.png)       |                | tree        |                                        ![tree](src/main/resources/markers/dynmap/tree.png)                                        |                |
| gear         |         ![gear](src/main/resources/markers/dynmap/gear.png)         |                | truck       |                                       ![truck](src/main/resources/markers/dynmap/truck.png)                                       |                |
| goldmedal    |    ![goldmedal](src/main/resources/markers/dynmap/goldmedal.png)    |                | up          |                                          ![up](src/main/resources/markers/dynmap/up.png)                                          |                |
| goldstar     |     ![goldstar](src/main/resources/markers/dynmap/goldstar.png)     |                  | walk        |                                        ![walk](src/main/resources/markers/dynmap/walk.png)                                        |               |
| greenflag    |    ![greenflag](src/main/resources/markers/dynmap/greenflag.png)    |                | warning     |                                     ![warning](src/main/resources/markers/dynmap/warning.png)                                     |                |
| hammer       |       ![hammer](src/main/resources/markers/dynmap/hammer.png)       |                | world       |                                       ![world](src/main/resources/markers/dynmap/world.png)                                       |                |
| heart        |        ![heart](src/main/resources/markers/dynmap/heart.png)        |                | wrench      |                                      ![wrench](src/main/resources/markers/dynmap/wrench.png)                                      |                |
| house        |        ![house](src/main/resources/markers/dynmap/house.png)        |                | yellowflag  |                                  ![yellowflag](src/main/resources/markers/dynmap/yellowflag.png)                                  |                |


The images used are modified versions of original Dynmap assets. You can find them here:

- [Dynmap on github](https://github.com/webbukkit/dynmap)
- [Original resources](https://github.com/webbukkit/dynmap/tree/v3.0/DynmapCore/src/main/resources/markers)

## Download
You can download the plugin on [GitHub](https://github.com/MayLAN-Craft/maylan-markers/releases)
