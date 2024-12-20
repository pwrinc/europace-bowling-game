# BowlingGame Challenge
Es handelt sich um eine CLI Anwendung gebaut mit Java Spring Boot (Spring Boot Version 3.4, Java Version 23). 

## Build 
Das Projekt kann mittels `./gradlew installDist` gebaut werden. Unter `build/install/bin/` finden sich nach dem build binaries für Linux (`bowling-game`) sowie Windows (`bowling-game.bat`). Voraussetzung für den build ist ein vorandens Java JDK in Version 23 (in meinem Fall habe ich OpenJDK genutzt):

```
$ java -version
openjdk version "23" 2024-09-17
OpenJDK Runtime Environment (build 23+37-2369)
OpenJDK 64-Bit Server VM (build 23+37-2369, mixed mode, sharing)
```

## Run
Um die Gesamtpunktzahl für ein komplettes Spiel (10 Frames) zu berechnen folgenen Befehl nutzen im Ordner `build/install/bin/`:
```
.\bowling-game calc --frame1 1,4 --frame2 4,5 --frame3 6,4 --frame4 5,5 --frame5 10,0 --frame6 0,1 --frame7 7,3 --frame8 6,4 --frame9 10,0 --frame10 2,8,6
```
Es erfolgt eine Ausgabe mit Berechnung des gesamten Scores:
```
Need to calculate score for frame set [1,4|4,5|6,4|5,5|10,0|0,1|7,3|6,4|10,0|2,8,6]
Calculated score is 133
```
Für Details `.\bowling-game calc -help` ausführen.

Für `help` die binary mit command `help` ausführen:
```
.\bowling-game help
```

## Bemerkungen
* Es müssen alle Frames als CLI Argumente übergeben werden (`--frame1` bis `--frame10`)
* Jeder Frame wird als Paar übergeben mit entsprechendr Anzahl der getroffenen Pins je Roll. Die Anzahlwerte sind durch Komma zu trennen: `--frame1 4,5` entspricht 4 getroffenen Pins im ersten und 5 getroffenen Pins im zweiten Roll. Insgesamt also 9.
* Bei einem Strike muss immer für den zweiten Roll trotzdem eine 0 als Anzahl mitgegeben werden: `--frame3 10,0` entspricht einem Strike im 3. Frame
* Der letzte Frame 10 besteht immer aus 3 Anzahlwerten. Auch wenn hier der 3. Versuch nicht genutzt wurde muss eine 0 angeben werden: `---frame10 4,5,0`
