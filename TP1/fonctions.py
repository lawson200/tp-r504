
def puissance (a,b):
	return a**b

# fonctions.py

def puissance(a, b):

    if not isinstance(a, int) or not isinstance(b, int):
        raise TypeError("Only integers are allowed for both arguments.")

    return a ** b

