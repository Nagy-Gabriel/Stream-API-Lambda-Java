Să se realizeze un program de evidentă a angajaților unei firme. Se va crea un proiect
Maven, care va conţine clasa Angajat cu următoarele variabile membre:
• numele (String)
• postul (String)
• data_angajarii (LocalDate)
• salariul (float).
Clasa va avea constructor cu parametri, constructor fără parametri, gettere şi settere
pentru accesul variabilelor membre şi va redefini metoda toString din clasa Object astfel încât
să returneze un String cu valorile variabilelor membre separate prin virgule


Cerințele de mai jos vor fi implementate utilizând facilitățile lui Java 8 (stream-uri,
expresii lambda, interfețe funcționale, referințe la metode, clasa Optional, etc) şi inferența
tipului pentru variabilele locale, facilitate introdusă în Java 10. Programul va implementa
următoarele cerințe:
1. Afișarea listei de angajați folosind referințe la metode.
2. Afișarea angajaților care au salariul peste 2500 RON. Rezolvarea va utiliza stream-uri.
Interfața funcțională Predicate, care este parametrul metodei de filtrare va fi
implementată printr-o expresie Lambda.
3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de
conducere (postul conține unul din cuvintele sef sau director). Pentru crearea unei liste
dintr-un stream se va utiliza operația terminală collect (Collectors.toList()). Se vor
utiliza steram-uri şi expresii lambda. Noua listă va fi apoi afișată. Anul curent se va citi
din sistem.
4. Afișarea angajaților care nu au funcție de conducere (postul lor nu conține cuvintele
director sau șef), în ordine descrescătoare a salariilor, folosind stream-uri şi expresii
lambda.
5. Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților
scrise cu majuscule. Rezolvarea va utiliza steram-uri, metoda map() şi operația
terminală collect(). Lista de String-uri va fi afișată.
6. Afișarea salariilor mai mici de 3000 de RON (doar salariile, fără alte informații)
folosind stream-uri, expresii lambda, referințe la metode şi metoda map().
7. Afișarea datelor primului angajat al firmei. Se va determina minimul din stream
furnizând comparatorul adecvat printr-o expresie Lambda. Dacă containerul Optional
returnat de funcția min() conține o valoare, atunci se va afișa acea valoare, altfel se va
afișa un mesaj corespunzător.
8. Afișarea de statistici referitoare la salariul angajaților. Se va afișa salariul mediu,
salariul minim şi salariul maxim. Rezolvarea va utiliza stream-uri şi operația terminală
collect(Collectors. summarizingDouble())
9. Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”. Se vor
afișa mesaje precum: „Firma are cel puțin un Ion angajat”, „Firma nu are nici un Ion
angajat”, în funcție de situație. Rezolvarea va utiliza stream-uri şi metoda findAny()
care va returna un container Optional care poate să conțină un element sau nu. Metoda
ifPresentOeElse din clasa Optional se va utiliza pentru afișarea mesajelor
corespunzătoare.
10. Afișarea numărului de persoane care s-au angajat în vara anului precedent. Se va
utiliza metoda count() din interfaţa Stream.
