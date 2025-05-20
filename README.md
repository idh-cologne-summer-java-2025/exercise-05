Fortgeschrittene Programmierung (Java 2)


# Übung 5


Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.

## Aufgabe 1

Sie finden im Repository eine neue Version des Geldautomaten (ATM) als Startpunkt. Dabei handelt es sich um den Geldautomaten, der zu einer Bank gehört, und den Kontostand verschiedener Konten auseinander halten kann. Ändern Sie den Code so, dass intern -- innerhalb der Klasse `Bank` -- eine `HashMap` verwendet wird. Die Account-Zählung soll bei der Nummer 7000001 beginnen und fortlaufen.


## Aufgabe 2

Noch kann jeder Kunde und jede Kundin mit der Kenntnis der Account-Nummer Geld von dem entsprechenden Konto abheben. Ändern Sie das, indem Sie einen vierstelligen Passcode mit angeben müssen, der überprüft wird. Speichern Sie den Passcode so, dass er nicht im Klartext gespeichert wird. (Tipp: der Hashcode zu einem int ist der int selbst, sie sollten da da wohl besser etwas anderes nutzen).

----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen am Quellcode, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 