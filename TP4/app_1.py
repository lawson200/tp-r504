from flask import Flask, render_template
import mysql.connector
import re 

app = Flask(__name__)
 
# MySQL configuration
db_config = {
    'host': 'tp4-sql',
    'user': 'root',
    'password': 'foo',
    'database': 'demosql'
}

# Initialize MySQL connection
conn = mysql.connector.connect(**db_config)
cursor = conn.cursor() 


@app.route('/')
def index():
    # Sample query
    query = "SELECT * FROM myTable"
    cursor.execute(query)
    data = cursor.fetchall()
    conn = mysql.connector.connect(**db_config)
    
    # Close the cursor and connection
    #cursor.close()
    #conn.close()
    
    return render_template('index.html', data=data)

#if __name__ == '__main__':
#    app.run(debug=True)
    
#modif

def new_user():
    message = ""
    if request.method == 'POST':
        username = request.form['username']
        message = critere(username)
    return render_template('newuser.html', message=message)
    
    
@app.route('/newuser/', methods=['GET', 'POST'], endpoint='new_user_1')
def new_user():
    message = ""
    if request.method == 'POST':
        username = request.form['username']
        message = validate_username(username)
    return render_template('newuser.html', message=message)

def validate_username(username):
    # Define regex patterns for each condition
    patt1 = r'.{6,}'            # At least 6 characters
    patt2 = r'.*\d.*'           # At least one digit
    patt3 = r'.*[A-Z].*'        # At least one uppercase letter
    patt4 = r'.*[a-z].*'        # At least one lowercase letter
    patt5 = r'.*[ #%{}@].*'     # At least one special character among #%{}@

    if re.fullmatch(patt1, username) is None:
        return "Echec sur la condition 1 : au moins 6 caractères."@app.route('/newuser/', methods=['GET', 'POST'], endpoint='new_user')

    elif re.fullmatch(patt2, username) is None:
        return "Echec sur la condition 2 : au moins un chiffre."
    elif re.fullmatch(patt3, username) is None or re.search(patt4, username) is None:
        return "Echec sur la condition 3 : au moins une majuscule et une minuscule."
    elif re.fullmatch(patt5, username) is None:
        return "Echec sur la condition 4 : au moins un caractère spécial parmi #%{}@."
    else:
        return "L'identifiant est valide."

if __name__ == '__main__':
    app.run(debug=True)

