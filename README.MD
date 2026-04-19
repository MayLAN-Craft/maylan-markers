## Maylan Markers

[ENGLISH README](README.EN.md)

![plugin_icon](Icon_EasyBMSignMarkers.png)

Идея проста: вы ставите табличку в игре, и она появляется на вашей карте BlueMap.

Этот плагин является форком старого, более не поддерживаемого решения — [BlueMapSignMarkers](https://modrinth.com/plugin/bluemapsignmarkers) 
и более нового [Easy BlueMap Sign Markers](https://github.com/deimiczny/easy-bmapmarkers). 
В текущую версию внесены упрощения и небольшие улучшения для удобства использования по сравнению с оригинальным кодом.
Цель состояла в том, чтобы сделать плагин максимально понятным для игроков и требующим минимум шагов для настройки.

Работает только на Paper 26.1.2+

## Установка

Вам необходимо иметь установленный **BlueMap** на вашем сервере, так как плагин напрямую зависит от него.
Если **BlueMap** уже установлен, просто поместите jar-файл в папку `plugins` вашего сервера... и готово\!

## Как использовать

Установите любую табличку в игре. Заполните её следующим образом:

- **1-я строка**: `[название_иконки]` (доступные теги иконок см. в разделе _Названия маркеров_)
- **2-я строка:** текст
- **3-я строка:** текст
- **4-я строка:** текст

**Примечание:** после создания маркера текст на первой строке изменится на `> marker <`. Это сделано для того, чтобы игроки понимали, что данная табличка является маркером, и не удалили её случайно.

Первая строка **ОБЯЗАТЕЛЬНО** должна быть заполнена. Если в первой строке нет корректного названия иконки, но используются скобки `[` и `]`, будет назначено значение по умолчанию — `[map]` — и маркер всё равно будет создан.
Из последующих трёх текстовых строк хотя бы одна должна быть заполнена. Если все они пусты, маркер не создастся. Мы исходим из того, что маркеру **нужно** описание.

## Пример

В примере ниже мы создадим маркер с иконкой звезды (`star`).

Сначала вы подписываете табличку:

![sign1](example1.png)

После завершения редактирования первая строка изменится на `> marker <`. Это означает, что маркер успешно установлен.

![sign2](example2.png)

Через некоторое время вы увидите маркер на вашей карте BlueMap:

![sign3](example3.png)

А если кликнуть по нему, появится всплывающее окно с описанием вашей таблички:

![sign4](example4.png)

## Названия маркеров

Ниже приведены доступные названия для маркеров и соответствующие им иконки. Просто впишите любое значение в квадратных скобках (например, `[bank]`), чтобы установить маркер на **BlueMap**.
Регистр букв не важен (можно писать как маленькими, так и заглавными), плагин всё поймёт.

| Название     | Иконка | Примечание | Название | Иконка | Примечание   |
|--------------|:-------------------------------------------------------------------:|----------------|-------------|:---------------------------------------------------------------------------------------------------------------------------------:|--------------|
| anchor       |       ![anchor](src/main/resources/markers/dynmap/anchor.png)       |                | key         |                                         ![key](src/main/resources/markers/dynmap/key.png)                                         |              |
| bank         |         ![bank](src/main/resources/markers/dynmap/bank.png)         |                | king        |                                        ![king](src/main/resources/markers/dynmap/king.png)                                        |              |
| basket       |       ![basket](src/main/resources/markers/dynmap/basket.png)       |                | left        |                                        ![left](src/main/resources/markers/dynmap/left.png)                                        |              |
| bed          |          ![bed](src/main/resources/markers/dynmap/bed.png)          |                | lightbulb   |                                   ![lightbulb](src/main/resources/markers/dynmap/lightbulb.png)                                   |              |
| beer         |         ![beer](src/main/resources/markers/dynmap/beer.png)         |                | lighthouse  |                                  ![lighthouse](src/main/resources/markers/dynmap/lighthouse.png)                                  |              |
| bighouse     |     ![bighouse](src/main/resources/markers/dynmap/bighouse.png)     |                | lock        |                                        ![lock](src/main/resources/markers/dynmap/lock.png)                                        |              |
| blueflag     |     ![blueflag](src/main/resources/markers/dynmap/blueflag.png)     |                | **map**         |                                         ![map](src/main/resources/markers/dynmap/map.png)                                         | По умолчанию |
| bomb         |         ![bomb](src/main/resources/markers/dynmap/bomb.png)         |                | minecart    |                                    ![minecart](src/main/resources/markers/dynmap/minecart.png)                                    |              |
| bookshelf    |    ![bookshelf](src/main/resources/markers/dynmap/bookshelf.png)    |                | offlineuser |                                 ![offlineuser](src/main/resources/markers/dynmap/offlineuser.png)                                 |              |
| bricks       |       ![bricks](src/main/resources/markers/dynmap/bricks.png)       |                | orangeflag  |                                  ![orangeflag](src/main/resources/markers/dynmap/orangeflag.png)                                  |              |
| bronzemedal  |  ![bronzemedal](src/main/resources/markers/dynmap/bronzemedal.png)  |                | pinkflag    |                                    ![pinkflag](src/main/resources/markers/dynmap/pinkflag.png)                                    |              |
| bronzestar   |   ![bronzestar](src/main/resources/markers/dynmap/bronzestar.png)   |                | pirateflag  |                                  ![pirateflag](src/main/resources/markers/dynmap/pirateflag.png)                                  |              |
| building     |     ![building](src/main/resources/markers/dynmap/building.png)     |                | pointdown   |                                   ![pointdown](src/main/resources/markers/dynmap/pointdown.png)                                   |              |
| cake         |         ![cake](src/main/resources/markers/dynmap/cake.png)         |                | pointleft   |                                   ![pointleft](src/main/resources/markers/dynmap/pointleft.png)                                   |              |
| camera       |       ![camera](src/main/resources/markers/dynmap/camera.png)       |                | pointright  |                                  ![pointright](src/main/resources/markers/dynmap/pointright.png)                                  |              |
| cart         |         ![cart](src/main/resources/markers/dynmap/cart.png)         |                | pointup     |                                     ![pointup](src/main/resources/markers/dynmap/pointup.png)                                     |              |
| caution      |      ![caution](src/main/resources/markers/dynmap/caution.png)      |                | portal      |                                      ![portal](src/main/resources/markers/dynmap/portal.png)                                      |              |
| chest        |        ![chest](src/main/resources/markers/dynmap/chest.png)        |                | purpleflag  |                                  ![purpleflag](src/main/resources/markers/dynmap/purpleflag.png)                                  |              |
| church       |       ![church](src/main/resources/markers/dynmap/church.png)       |                | queen       |                                       ![queen](src/main/resources/markers/dynmap/queen.png)                                       |              |
| coins        |        ![coins](src/main/resources/markers/dynmap/coins.png)        |                | redflag     |                                     ![redflag](src/main/resources/markers/dynmap/redflag.png)                                     |              |
| comment      |      ![comment](src/main/resources/markers/dynmap/comment.png)      |                | right       |                                       ![right](src/main/resources/markers/dynmap/right.png)                                       |              |
| compass      |      ![compass](src/main/resources/markers/dynmap/compass.png)      |                | ruby        |                                        ![ruby](src/main/resources/markers/dynmap/ruby.png)                                        |              |
| construction | ![construction](src/main/resources/markers/dynmap/construction.png) |                | scales      |                                      ![scales](src/main/resources/markers/dynmap/scales.png)                                      |              |
| cross        |        ![cross](src/main/resources/markers/dynmap/cross.png)        |                | shield      |                                      ![shield](src/main/resources/markers/dynmap/shield.png)                                      |              |
| cup          |          ![cup](src/main/resources/markers/dynmap/cup.png)          |                | sign        |                                        ![sign](src/main/resources/markers/dynmap/sign.png)                                        |              |
| cutlery      |      ![cutlery](src/main/resources/markers/dynmap/cutlery.png)      |                | silvermedal |                                 ![silvermedal](src/main/resources/markers/dynmap/silvermedal.png)                                 |              |
| diamond      |      ![diamond](src/main/resources/markers/dynmap/diamond.png)      |                | silverstar  |                                  ![silverstar](src/main/resources/markers/dynmap/silverstar.png)                                  |              |
| dog          |          ![dog](src/main/resources/markers/dynmap/dog.png)          |                 | skull       |                                       ![skull](src/main/resources/markers/dynmap/skull.png)                                       |              |
| door         |         ![door](src/main/resources/markers/dynmap/door.png)         |                | star        |                                        ![star](src/main/resources/markers/dynmap/star.png)                                        |              |
| down         |         ![down](src/main/resources/markers/dynmap/down.png)         |                | sun         |                                         ![sun](src/main/resources/markers/dynmap/sun.png)                                         |              |
| drink        |        ![drink](src/main/resources/markers/dynmap/drink.png)        |                | temple      |                                      ![temple](src/main/resources/markers/dynmap/temple.png)                                      |              |
| end  |  ![exclamation](src/main/resources/markers/dynmap/end.png)  |                | theater     |                                     ![theater](src/main/resources/markers/dynmap/theater.png)                                     |              |
| exclamation  |  ![exclamation](src/main/resources/markers/dynmap/exclamation.png)  |                | tornado     |                                     ![tornado](src/main/resources/markers/dynmap/tornado.png)                                     |              |
| factory      |      ![factory](src/main/resources/markers/dynmap/factory.png)      |                | tower       |                                       ![tower](src/main/resources/markers/dynmap/tower.png)                                       |              |
| fire         |         ![fire](src/main/resources/markers/dynmap/fire.png)         |                | tree        |                                        ![tree](src/main/resources/markers/dynmap/tree.png)                                        |              |
| flower       |       ![flower](src/main/resources/markers/dynmap/flower.png)       |                | truck       |                                       ![truck](src/main/resources/markers/dynmap/truck.png)                                       |              |
| gear         |         ![gear](src/main/resources/markers/dynmap/gear.png)         |                | up          |                                          ![up](src/main/resources/markers/dynmap/up.png)                                          |              |
| goldmedal    |    ![goldmedal](src/main/resources/markers/dynmap/goldmedal.png)    |                | walk        |                                        ![walk](src/main/resources/markers/dynmap/walk.png)                                        |              |
| goldstar     |     ![goldstar](src/main/resources/markers/dynmap/goldstar.png)     |                 | warning     |                                     ![warning](src/main/resources/markers/dynmap/warning.png)                                     |              |
| greenflag    |    ![greenflag](src/main/resources/markers/dynmap/greenflag.png)    |                | world       |                                       ![world](src/main/resources/markers/dynmap/world.png)                                       |              |
| hammer       |       ![hammer](src/main/resources/markers/dynmap/hammer.png)       |                | wrench      |                                      ![wrench](src/main/resources/markers/dynmap/wrench.png)                                      |              |
| heart        |        ![heart](src/main/resources/markers/dynmap/heart.png)        |                | yellowflag  |                                  ![yellowflag](src/main/resources/markers/dynmap/yellowflag.png)                                  |              |
| house        |        ![house](src/main/resources/markers/dynmap/house.png)        |                | x |                                  x                                  |              |

Используемые изображения являются апскейлом оригинальных ассетов Dynmap. Вы можете найти их здесь:

- [Dynmap на GitHub](https://github.com/webbukkit/dynmap)
- [Оригинальные ресурсы](https://github.com/webbukkit/dynmap/tree/v3.0/DynmapCore/src/main/resources/markers)

## Скачать

Вы можете скачать плагин на [GitHub](https://github.com/MayLAN-Craft/maylan-markers/releases)
