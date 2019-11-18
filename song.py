import requests as req
from bs4 import BeautifulSoup as bs
import csv

c=0
url='https://bestoftheyear.in/songs/bollywood/page/63/'
for i in range(1,3):
	resp=req.get(url)
	soup=bs(resp.text,'html.parser')
	llist=soup.find_all('div',{'class':'music-data'})
	for j in llist:
		for k in j.find_all('h4'):
			k=k.text
		for l in j.find_all('div',{'class':'music-singer'}):
			l=l.text
		for o in j.find_all('div',{'class':'music-genre'}):
			o=o.text
		for m in j.find_all('div',{'class':'music-album'}):
			m=m.text
		for f in j.find_all('div',{'class':'user-rating'}):
			f=f.text
			c=c+1
			print(c)
		with open('ex.csv', mode='a', newline='') as file:
			writer=csv.writer(file, delimiter=',',quotechar='"',quoting=csv.QUOTE_MINIMAL)
			writer.writerow([c, k, l[3:], o, m[7:], f[11:]])
	list1=soup.find_all('a',{'class':'next'})
	for i in list1:
		url=i.get('href')

print(c)

#Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36o