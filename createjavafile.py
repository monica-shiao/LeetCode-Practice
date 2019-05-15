import datetime, requests, json, re, os

time = datetime.datetime.now() #現在時間
cur_time = str(time.year) + "/" + str(time.month) + "/" + str(time.day)

class LeetCode():

	def __init__(self):
		self.pb_content = ""
		self.pb_name = ""
		self.file_name = ""
		self.file_folder_num = 0
		self.file_tag = ""
		self.difficultys = ['easy', 'medium', 'hard']
		self.file_folder = ['Array','Backtracking', 'BFS','Binary_Search', 'Binary_Search_Tree','Bit_Manipulation','DFS','Divide&Conquer', 'Dynamic_Programming','Graph','Heap','Hash_Table','Linked_List', 'Math', 'Queqe', 'Sort','Stack', 'String', 'Tree','Two_Pointers']

	# Using problem No. to get the name and level of problem.
	def getLeetCodeProblems(self, pb_num):
	    api_content = requests.get('https://leetcode.com/api/problems/algorithms/').content

	    questions = json.loads(api_content)['stat_status_pairs']

	    for i in range(len(questions) - 1, -1, -1): 
	        if questions[i]['stat']['frontend_question_id'] == pb_num:
	            question = questions[i]
	            self.pb_name = question['stat']['question__title_slug']
	            name = question['stat']['question__title'].replace(" ","_")
	            level = self.difficultys[question['difficulty']['level'] - 1]
	            break
	    
	    self.file_name = level+"_"+str(pb_num)+"_"+name
	    self.getProblemContent(pb_num)

	# Using problem No. to get the content of problem.
	def getProblemContent(self, pb_num):

		url = "https://leetcode.com/graphql"
		payload = "{\"operationName\":\"questionData\",\"variables\":{\"titleSlug\":\""+self.pb_name+"\"},\"query\":\"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    enableTestMode\\n    envInfo\\n    libraryUrl\\n    __typename\\n  }\\n}\\n\"}"
		headers = {
		    'X-NewRelic-ID': "UAQDVFVRGwEAXVlbBAg=",
		    'content-type': "application/json",
		    'x-csrftoken': "NfCAT69reQUgFsc6r586mULo5Alyd4wnvxS3h8rfOqIkJQ8fdV89QPPeG7Hr8pCo",
		    'Cookie': "__cfduid=d72d52e581bd2d14c23be77cb82b305641549887945; csrftoken=NfCAT69reQUgFsc6r586mULo5Alyd4wnvxS3h8rfOqIkJQ8fdV89QPPeG7Hr8pCo; LEETCODE_SESSION=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiNDAxNjM3IiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiYWxsYXV0aC5hY2NvdW50LmF1dGhfYmFja2VuZHMuQXV0aGVudGljYXRpb25CYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiNGVmZmNkMjNkNmEzMmVjNWY2OGFjZGY3ZGQxM2JhZTE3ZTQzZTBiMSIsImlkIjo0MDE2MzcsImVtYWlsIjoidGhlb2tsZWludHdAZ21haWwuY29tIiwidXNlcm5hbWUiOiJUaGVvS2xlaW4iLCJ1c2VyX3NsdWciOiJ0aGVva2xlaW4iLCJhdmF0YXIiOiJodHRwczovL3d3dy5ncmF2YXRhci5jb20vYXZhdGFyLzliNDk1ZTE5OWQ4ZGFkMjEzMGVjYjQ0MDdkY2E0MTc2LnBuZz9zPTIwMCIsInRpbWVzdGFtcCI6IjIwMTktMDMtMTIgMDE6MjQ6MTAuMjkxNzIzKzAwOjAwIiwiUkVNT1RFX0FERFIiOiIxNDAuMTM2LjUwLjE5NSIsIklERU5USVRZIjoiMDcwMjliMjRlNDk1ZjZhZmE1YTE2ZTE3MjRmNzJmNTUiLCJfc2Vzc2lvbl9leHBpcnkiOjEyMDk2MDB9.9Q8Q-tV3mxsLOKvE9FEFJLxd9zMuNTsl1c7OmbGbS84; __stripe_mid=71443dd7-3e02-4083-8ecd-0446d2ba6b4f; c_a_u=VGhlb0tsZWlu:1h7JfZ:KvOzIKekyEr03j_P2d1SioCcGvw",
		    'cache-control': "no-cache",
		    'Postman-Token': "a1554639-0d06-46ff-b5e5-5bfd6884f116"
		    }

		response = requests.post(url, data=payload, headers=headers).json()

		reg = re.compile('<[^>]*>')
		self.pb_content = reg.sub('',response['data']['question']['content']).replace("&amp;","&").replace("&quot;", '"').replace("&apos;", "'").replace("&gt;",">").replace("&lt;", "<").replace("&nbsp;", "").replace("&le;", "<=").replace("&ge;", ">=").replace("&#39;", "'")


	def getFileSavedLocation(self):
		cnt = 1;
		for i in self.file_folder:
		    print("{} : {}".format(str(cnt),i))
		    cnt+=1
		self.file_folder_num = int(input("請輸入要放置的資料夾位置(數字)："))-1
		self.file_tag = self.file_folder[self.file_folder_num]
		self.newFile()

	def newFile(self):
		file = open("./Java/" + self.file_folder[self.file_folder_num] + "/" + self.file_name + ".java", 'w')
		content = """/***
Tags: {}
Create: {}
Update: {}

Problem description:
{}
***/

""".format(self.file_tag, cur_time, cur_time, self.pb_content)

		file.write(content)
		file.close()

		print("已將 " + self.file_name + ".java 檔案新增至 " + self.file_folder[self.file_folder_num]+ " 資料夾中")
		os.system("open ./Java/" + self.file_folder[self.file_folder_num] + "/" + self.file_name + ".java")



problem_num = int(input("Problem No: "))

leetcode = LeetCode()

leetcode.getLeetCodeProblems(problem_num)

leetcode.getFileSavedLocation()
