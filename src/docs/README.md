# Korrekturvorschläge Skript

### 8 Vererbung

Ersetze

> "Dabei erbt die Klasse B zunächst alle Bestandteile - also Attribute und Methoden - von der Klasse A;"

durch 

> "Dabei erbt die Klasse B zunächst Bestandteile - also Attribute und Methoden entsprechend ihrer Zugriffsrechte - von der Klasse A;"

(Bezug: Skript, Kapitel 8.6 f., vgl. auch https://docs.oracle.com/javase/specs/jls/se21/html/jls-8.html#d5e13702, abgerufen 03.12.2023)

### 8.8 Schnittstellen

Ersetze 

> "Ein Interface spezifiziert Methoden lediglich, es implementiert sie nicht"

durch

> "Ein Interface spezifiziert Methoden oder erlaubt eine Implementierung über Methoden, die
 mit `default` gekennzeichnet sind.

(Bezug: Seit Java 8, vgl. auch https://docs.oracle.com/javase/specs/jls/se11/html/jls-9.html#jls-InterfaceMethodModifier
sowie https://docs.oracle.com/javase/specs/jls/se11/html/jls-13.html#d5e20922, beides abgerufen 03.12.2023)

