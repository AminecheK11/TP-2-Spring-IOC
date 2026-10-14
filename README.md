# TP2 - Spring IoC et Injection de Dépendances

**Réalisé par : Amine Chekkouri**

## Objectif

Ce TP a pour objectif de mettre en œuvre les principes fondamentaux de Spring, notamment l'Inversion de Contrôle (IoC) et l'Injection de Dépendances (DI).

Les principales fonctionnalités réalisées sont :

- création d'un projet Spring avec Maven ;
- définition d'une interface DAO et de plusieurs implémentations ;
- injection automatique des dépendances avec Spring ;
- utilisation de `@Autowired` et `@Qualifier` ;
- configuration alternative avec un fichier XML ;
- réalisation d'un test unitaire avec JUnit ;
- utilisation des profils Spring `dev` et `prod`.

---

## 1. Injection de dépendances avec Spring

L'application utilise une interface `IDao` ainsi qu'une couche métier représentée par `IMetier` et `MetierImpl`.

La première implémentation DAO retourne la valeur `100.0`. La méthode `calcul()` de la couche métier multiplie cette valeur par 2.

Le résultat obtenu est donc :

- Valeur DAO : 100.0
- Résultat : 200.0

<img width="521" height="190" alt="cap1 1_tp2_nouv_chap" src="https://github.com/user-attachments/assets/89eff93e-2bd9-4136-8fee-1fccb97555ee" />


---

## 2. Utilisation de @Qualifier

Une deuxième implémentation `DaoImpl2` a été ajoutée. Elle retourne la valeur `150.0`.

L'annotation `@Qualifier("dao2")` permet d'indiquer à Spring quelle implémentation de `IDao` doit être injectée dans `MetierImpl`.

Le résultat obtenu est :

- Valeur DAO : 150.0
- Résultat : 300.0

<img width="386" height="195" alt="cap1_tp2_nouv_chap" src="https://github.com/user-attachments/assets/7856601c-ffc6-4ab9-ad96-6bf33f932aae" />


---

## 3. Test unitaire de la couche métier

Un test unitaire JUnit a été créé pour vérifier le fonctionnement de la méthode `calcul()` de `MetierImpl`.

Une implémentation fictive de `IDao` retourne la valeur `10.0`. La dépendance est injectée manuellement dans `MetierImpl`.

Le résultat attendu est donc `20.0`.

Le test s'exécute correctement avec :

- 1 test exécuté ;
- 1 test réussi ;
- code de sortie 0.

<img width="572" height="173" alt="cap3_tp2_nouv_chap" src="https://github.com/user-attachments/assets/ccd8796b-afc6-400e-b1c4-a0681073ebc1" />


---

## 4. Configuration XML de Spring

Une configuration alternative a été réalisée avec le fichier `applicationContext.xml`.

Les beans `dao`, `dao2` et `metier` sont déclarés dans ce fichier. La dépendance `dao2` est injectée dans le bean `metier` à l'aide d'une propriété.

L'exécution de `PresentationXML` donne :

- Résultat XML : 300.0

<img width="606" height="191" alt="cap4_tp2_nouv_chap" src="https://github.com/user-attachments/assets/dd9e1224-31e8-4393-b45f-2a89800a5806" />


---

## 5. Utilisation des profils Spring

Les profils Spring permettent d'utiliser différentes implémentations selon l'environnement.

Deux profils ont été définis :

- `prod` pour `DaoImpl` ;
- `dev` pour `DaoImpl2`.

Le profil `dev` est activé dans `Presentation2`.

Spring utilise donc `DaoImpl2`, qui retourne `150.0`.

Le résultat obtenu est :

- Version de développement
- Résultat : 300.0

<img width="442" height="209" alt="cap5_tp2_nouv_chap" src="https://github.com/user-attachments/assets/5748ce61-b352-4c89-a519-4b8856fe1f46" />


---

## Conclusion

Ce TP m'a aidé à comprendre et à appliquer les principes d'Inversion de Contrôle (IoC) et d'Injection de Dépendances (DI) avec Spring.

J'ai utilisé les annotations `@Autowired`, `@Qualifier` et `@Profile`, ainsi que la configuration XML et les tests unitaires avec JUnit.
