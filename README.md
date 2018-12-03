# LibraryRecommendation

#To execute the Application run the jar from target folder of project :
  java -jar zenjob-0.0.1-SNAPSHOT.jar
  
  OR
  
 Import the project in Eclipse and run the App class(as it is a spring boot project).
 
 #Services:
 1. URL : http://localhost:50051/library/user/register
    Type : POST
    Request :
    {
	"username" : "testuser@gmail.com",
	"age" : 26,
	"categories" : ["Children's Books","Literature & Fiction","Medical Books","Engineering & Transportation"]
    }
    Response :
    [
    {
        "id": 10,
        "isbn": "545700272",
        "title": "A Handful of Stars",
        "author": "Cynthia Lord",
        "categoryId": 4
    },
    {
        "id": 30,
        "isbn": "147514940",
        "title": "Fantasy League",
        "author": "Mike Lupica",
        "categoryId": 4
    },
    {
        "id": 41,
        "isbn": "688135765",
        "title": "Shortcut",
        "author": "Donald Crews",
        "categoryId": 4
    },
    {
        "id": 56,
        "isbn": "618428852",
        "title": "United States History  Early Years (Level 5): Houghton Mifflin Social Studies",
        "author": "HOUGHTON MIFFLIN",
        "categoryId": 4
    },
    {
        "id": 75,
        "isbn": "763652326",
        "title": "Mercy Watson: Something Wonky this Way Comes",
        "author": "Kate DiCamillo",
        "categoryId": 4
    },
    {
        "id": 6,
        "isbn": "312556411",
        "title": "Literature and Its Writers: A Compact Introduction to Fiction, Poetry, and Drama",
        "author": "Ann Charters",
        "categoryId": 15
    },
    {
        "id": 58,
        "isbn": "1250036658",
        "title": "This Book Is Full of Spiders: Seriously, Dude, Don't Touch It (John Dies at the End)",
        "author": "David Wong",
        "categoryId": 15
    },
    {
        "id": 80,
        "isbn": "300200676",
        "title": "Eternity's Sunrise: The Imaginative World of William Blake",
        "author": "Leo Damrosch",
        "categoryId": 15
    },
    {
        "id": 104,
        "isbn": "618155872",
        "title": "The Best American Essays of the Century (The Best American Series)",
        "author": "",
        "categoryId": 15
    },
    {
        "id": 127,
        "isbn": "674990854",
        "title": "Seneca: Epistles 66-92 (Loeb No. 76)",
        "author": "Seneca",
        "categoryId": 15
    },
    {
        "id": 1,
        "isbn": "044310073X",
        "title": "Oral and Maxillofacial Surgery: An Objective-Based Textbook, 2e",
        "author": "",
        "categoryId": 16
    },
    {
        "id": 39,
        "isbn": "1622020758",
        "title": "ICD-10-CM 2015: The Complete Official Codebook",
        "author": "",
        "categoryId": 16
    },
    {
        "id": 45,
        "isbn": "323072534",
        "title": "Manual of High Risk Pregnancy and Delivery, 5e (Manual of High Risk Pregnancy & Delivery)",
        "author": "Elizabeth S. Gilbert RNC  MS  FNPc",
        "categoryId": 16
    },
    {
        "id": 69,
        "isbn": "71825053",
        "title": "Basic and Clinical Pharmacology 13 E",
        "author": "Bertram Katzung",
        "categoryId": 16
    },
    {
        "id": 82,
        "isbn": "1593853084",
        "title": "Treating Trauma and Traumatic Grief in Children and Adolescents",
        "author": "Judith A. Cohen",
        "categoryId": 16
    },
    {
        "id": 7,
        "isbn": "393339157",
        "title": "Straight on Till Morning: The Life of Beryl Markham",
        "author": "Mary S. Lovell",
        "categoryId": 10
    },
    {
        "id": 126,
        "isbn": "764967665",
        "title": "Art for London Transport 2015 Calendar",
        "author": "",
        "categoryId": 10
    },
    {
        "id": 225,
        "isbn": "470288574",
        "title": "Geographic Information Analysis",
        "author": "David O'Sullivan",
        "categoryId": 10
    },
    {
        "id": 319,
        "isbn": "1931464561",
        "title": "The M1 Garand Rifle",
        "author": "Bruce N. Canfield",
        "categoryId": 10
    },
    {
        "id": 388,
        "isbn": "3527299963",
        "title": "Stirring: Theory and Practice",
        "author": "Marko Zlokarnik",
        "categoryId": 10
    }
]

2. User Feedback :
  URL :http://localhost:50051/library/book/feedback
  Type : POST
  Request :
  {
	"username" : "taoriraksha@gmail.com",
	
	"booksFeedback" : 
				[
					{
						"title" : "Fantasy League",
						"feedback" : "Liked"
					},
					{
						"title" : "Shortcut",
						"feedback" : "Disliked"
					},
					{
						"title" : "United States History  Early Years (Level 5): Houghton Mifflin Social Studies",
						"feedback" : "Liked"
					}
					]
}
Response : 200(OK)

#Database:
H2 datatabase
Check on browser : http://localhost:50051/h2-console/
  Tables : USER,BOOK,FEEDBACK
  
