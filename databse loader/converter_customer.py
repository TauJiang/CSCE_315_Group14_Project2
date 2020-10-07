import psycopg2
import json
import os

# Connect to 315 database 
# Use an environment variable too access db password
conn = psycopg2.connect("host=csce-315-db.engr.tamu.edu dbname=project2_group14 user=entao password=727005069")
cur = conn.cursor()

# Temporary variables to hold the io data
review_id = ''
user_id = ''
business_id = ''

stars = 0

# Read in json data
file = open('yelp_academic_dataset_user.json', 'r', encoding="utf8")
#data = json.load(f)
#print("file opened")
  # Iterate over each line of the data, whcih in this case is a seperate json data entry
for rline in file.readlines():
  line = json.loads(rline)
  # Messy, but don't attempt to insert if a data field isn't read properly
  missing_data = False
  # Dictionary access this lines values for the keys that match our schema
  if 'user_id' in line:
    user_id = line['user_id']
  else:
    missing_data = True
  if 'yelping_since' in line:
    yelping_since = line['yelping_since']
  else:
    missing_data = True
  if 'useful' in line:
    useful = line['useful']
  else:
    missing_data = True
  if 'funny' in line:
    funny = line['funny']
  else:
    missing_data = True
  if 'elite' in line:
    elite = line['elite']
  else:
    missing_data = True
  if 'average_stars' in line:
    average_stars = line['average_stars']
  else:
    missing_data = True
  if 'name' in line:
    name = line['name']
  else:
    missing_data = True
  if 'review_count' in line:
    review_count = line['review_count']
  else:
    missing_data = True
  #print("finish")

  # Only insert the values to test if they are all present
  if not missing_data:
    # WARNING: Will halt operation if there is a duplicate PRIMARY_KEY
    cur.execute(
      "INSERT INTO customer VALUES (%s, %s, %s, %s, %s, %s, %s, %s)",
      (user_id, name, review_count, yelping_since, useful, funny, elite, average_stars)
    )
    #print(user_id)
    conn.commit()

# Commit everything to the database
#conn.commit()