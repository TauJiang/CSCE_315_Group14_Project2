import psycopg2
import json
import os

# Connect to 315 database 
# Use an environment variable too access db password
conn = psycopg2.connect("host=csce-315-db.engr.tamu.edu dbname=project2_group14 user=entao password=727005069")
cur = conn.cursor()

# Temporary variables to hold the io data
bid = ''
name = ''
stars = 0

# Read in json data
with open('business.json', 'r') as f:
  data = json.load(f)

  # Iterate over each line of the data, whcih in this case is a seperate json data entry
  for line in data:
    # Messy, but don't attempt to insert if a data field isn't read properly
    missing_data = False
    # Dictionary access this lines values for the keys that match our schema
    if 'business_id' in line:
      bid = line['business_id']
    else:
      missing_data = True
    if 'name' in line:
      name = line['name']
    else:
      missing_data = True
    if 'stars' in line:
      stars = line['stars']
    else:
      missing_data = True

    # Only insert the values to test if they are all present
    if not missing_data:
      # WARNING: Will halt operation if there is a duplicate PRIMARY_KEY
      cur.execute(
        "INSERT INTO test VALUES (%s, %s, %s)",
        (bid, name, stars)
      )

# Commit everything to the database
conn.commit()