# POBJ Arc 2 : Multi-ensembles (TME 4 et 5)

### Support de TME du cours programmation par objets (LU3IN002), Licence 3, Sorbonne Université, Paris, France.

# Objectifs pédagogiques :
• création d’une nouvelle collection : les multi-ensembles ;
• utilisation de la collection Map ;
• création d’un itérateur.

# But
Les collections de la bibliothèque standard Java proposent de nombreuses interfaces de conteneurs
et plusieurs implantations de chaque interface. Dans ce TME, nous allons construire un nouveau
type de collection : les multi-ensembles, MultiSet. Cette collection nous resservira également lors
du prochain TME.
Un multi-ensemble est une liste non-ordonnée d’éléments. Contrairement à un ensemble classique,
un élément peut apparaître plusieurs fois dans un multi-ensemble, et il convient de se souvenir du
nombre d’occurrences. Une application intéressante des multi-ensembles que nous allons explorer
dans ce TME est le comptage de la fréquence d’apparition des mots dans un texte pour déterminer
les mots les plus fréquents.
Plusieurs implantations des multi-ensembles sont possibles. Une implantation naïve consisterait à
utiliser une List (par exemple ArrayList), mais celle-ci ne possède pas une bonne complexité pour
notre application (le comptage de mots). Nous allons à la place utiliser une Map, qui associe à chaque
élément son nombre d’occurrences. Notez que nous ne pouvons pas utiliser Set, car il ne permet
pas à un élément d’apparaître plusieurs fois.
Notre multi-ensemble est polymorphe. Comme pour les collections Java, nous utilisons les types
génériques. Nous écrirons donc MultiSet<T>
