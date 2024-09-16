print("Hello World!")

# main.py

# Import du module fonctions
import fonctions as f

while True:

        a = float(input("Entrez le premier nombre  : "))
        b = float(input("Entrez le second nombre (exposant) : "))

        # Conversion en entiers
        c = int(a)
        d = int(b)

        res = f.puissance(c, d)

        print(f"{c} élevé à la puissance {d} est {res}.")


