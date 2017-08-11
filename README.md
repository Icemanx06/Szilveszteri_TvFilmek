Szilveszteri tévéfilmek (Java)
Szilveszter éjszakáját sok ember a televízió előtt ülve tölti, és fel sem áll a tévéből ömlő filmek elől.
Az ön feladata, hogy írjon egy programot, amely kimutatást készít az idei szilveszterről az első parancssori argumentumaként megadott
szöveges állományból olvasott adatok alapján!
Az állomány egy-egy sora azt írja le, hogy egy-egy ember mikor milyen tévéfilmet nézett szilveszter éjszakáján:
ember_neve:hh.mm-hh.mm->film_címe[;hh.mm-hh.mm->film_címe]…
Sem az emberek nevei, sem a filmek címei nem tartalmaznak kettőspont vagy pontosvessző karaktert,
és nem tartalmazzák a -> többkarakteres szimbólumot sem, ezek az emberek neveinek, a filmcímeknek, 
illetve a filmek kezdési és befejezési időpontjainak az elválasztására szolgálnak.
Egy-egy film esetében a kezdési időpont mindig megelőzi a befejezési időpontot, de ügyeljen rá, hogy lehetnek olyan tévéfilmek, 
ahol a kezdés időpontja még szilveszterre, a befejezés időpontja viszont már az új év első napjára esik!
Az egyszerűség kedvéért feltételezzük, hogy 23.59-et 0.00 követi, illetve hogy 0 ≤ hh < 24 és 0 ≤ mm < 60 minden esetben. 
Két filmet azonosnak tekintünk, ha mind a címük, mind a hosszuk azonos.
A program írja a standard kimenetre lexikografikusan növekvő sorrendben azoknak a filmeknek a címeit, 
amelyek a leghosszabb vetítési idővel rendelkeznek, és minden ilyen filmcím mellett, attól egy kettőspont és 
egy szóköz karakterrel elválasztva szerepeljen ott azoknak az embereknek a neve is, akik megnézték ezt a filmet! 
Ha egy filmet több ember is megnézett szilveszter éjszakáján, akkor ezeknek az embereknek a nevét lexikografikusan növekvő sorrendben,
egymástól egy vessző és egy szóköz karakterrel elválasztva írja a standard kimenetre!
Ügyeljen rá, hogy a sorok végén ne álljon semmilyen felesleges karakter (se szóköz, se vessző, se ezek kombinációja)!

Példa állomány (sample.txt):
Janos:0.00-0.05->Himnusz
Peter:0.00-0.02->Himnusz
Vivien:23.56-0.01->Himnusz

Parancssori argumentumok:
sample.txt

A futtatás eredménye a standard kimeneten:
Himnusz: Janos, Vivien

Példa állomány (sample2.txt):
Janos:19.30-20.50->Humorkoktel;3.35-5.20->Az olasz melo
Peter:21.00-23.15->Es megint duhbe jovunk;3.35-5.20->Az olasz melo
Vivien:15.20-17.00->A Pogany Madonna;3.35-5.20->Az olasz melo

Parancssori argumentumok:
sample2.txt

A futtatás eredménye a standard kimeneten:
Es megint duhbe jovunk: Peter
