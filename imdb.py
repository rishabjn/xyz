from bs4 import BeautifulSoup as bs
import webbrowser as wb
import requests


c=0
file = open('read.txt','a')
url = 'https://www.imdb.com/list/ls057823854/?sort=list_order,asc&st_dt=&mode=detail&page=1'
for i in range(1,2):
	resp=requests.get(url)
	print(resp)				#if code:200 connection established
	soup = bs(resp.text)
	llist = soup.find_all('div',{'class':'lister-item-content'})
	for i in llist:
		for j in i.find_all('h3'):
			l=j.text
			print(l[4:len(l)-7])
			c=c+1
		for u in i.find_all('span',{'class':'genre'}):
			x = u.text
			print(x)
		


	
	llist2 = soup.find_all('div',{'class':'desc'})
	for i in llist2:
		for j in i.find_all('a'):
			link=j.get('href')
	nurl='https://www.imdb.com/'+link
	file.write(nurl)
print(c)