

def puissance(a, b):


    if not isinstance(a, int) or not isinstance(b, int):
        raise TypeError("Only integers are allowed for both arguments.")

    if b == 0:
        return 1
    negatif = False
    if b < 0:
        negatif = True
        b = -b

    resultat = 1
    for _ in range(b):
        resultat *= a

    if negatif:
        return 1 / resultat
    
    return resultat

