Restaurant - Arhitectura Proiect

Interfata:

    - SelectorBucatar

Clase:

    - Restaurant
    - Masa
    - Comanda
        - ComandaMancare
        - ComandaBautura
        - ComandaMancareSiBautura
    - Bucatar
    - Ospatar
    - SelectorEchilibru
    - SelectorSpecializare

Enum-uri:

    - Specializare (pentru bucatari)
    - TipClient

Design Pattern-uri utilizate:

- Singleton - clasa Restaurant
- Strategy - selectarea bucatarului
- Prototype???? - pentru mai multe tipuri de comenzi
- Observer - ospatarul trebuie sa stie mereu numarul de mese ocupate si stadiul bucatarilor (este notifiat de fiecare data cand  ceva se schimba)

Modificari necesare pentru:

- Tehnica de alegere a bucatarului:
    - se va crea o noua clasa de tip "Selector..." care va implementa interfata SelectorBucatar
    - in aceasta clasa, se va crea noua strategie
    - schimbarea strategiei presupune doar inlocuirea initializatii selectorului cu cel nou in momentul trimiterii comenzilor

- Modificarea numarului de mese:
    - Restaurantul are un numar de mese intial preinitializat
    - Pentru adaugarea meselor, exista o metoda dedicata ce incrementeaza numarul de mese si le adauga in lista pe rand
    - Pentru scoaterea meselor, este scrisa o metoda similara
    - Adaugarea/Scoaterea meselor se poate face prin apelarea metodelor

- Existenta unor tipuri diferite de comenzi:
    - clasa comanda este abstracta
    - clasele ComandaMancare, ComandaBautura, ComandaMancare si bautura extind clasa Comanda
    - pentru adaugarea unui nou tip de comanda se va crea o noua clasa ce extinde clasa Comanda si se va implementa noua functionalitate acolo