def create_sql():
    with open("insert_test_users.sql", "w") as f:
        f.write("BEGIN;\n\n")
        
        # Insert into 'signon' table
        f.write("INSERT INTO signon (username, password) VALUES\n")
        for i in range(3, 101):
            f.write(f"('user{i}', 'password{i}'){',' if i < 100 else ';'}\n")
        
        f.write("\n")
        
        # Insert into 'account' table
        f.write("INSERT INTO account (username, email, first_name, last_name, status, addr1, addr2, city, state, zip, country, phone) VALUES\n")
        for i in range(3, 101):
            f.write(f"('user{i}', 'user{i}@yourdomain.com', 'First{i}', 'Last{i}', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-555{i:03d}'){',' if i < 100 else ';'}\n")
        
        f.write("\n")
        
        # Insert into 'profile' table
        f.write("INSERT INTO profile (username, langpref, favcategory, mylistopt, banneropt) VALUES\n")
        for i in range(3, 101):
            category = 'CATS' if i % 2 == 0 else 'DOGS'
            f.write(f"('user{i}', 'english', '{category}', 1, 1){',' if i < 100 else ';'}\n")
        
        f.write("\nCOMMIT;\n")

if __name__ == "__main__":
    create_sql()
