import re, requests, json, datetime

class ReadMe():
	def __init__(self):
		self.pb_name = ""
		self.file_tag = ""
		self.level = ""
		self.version_num = 0
		self.difficultys = ['easy', 'medium', 'hard']
		self.file_folder = ['Array','Backtracking', 'BFS','Binary_Search', 'Binary_Search_Tree''Bit_Manipulation','DFS','Divide&Conquer', 'Dynamic_Programming','Graph','Heap','Hash_Table', 'Math', 'Queqe', 'Sort','Stack', 'String', 'Tree','Two_Pointers']
		self.month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']

	def getProblemName(self, pb_num):
	    api_content = requests.get('https://leetcode.com/api/problems/algorithms/').content

	    questions = json.loads(api_content)['stat_status_pairs']

	    for i in range(len(questions) - 1, -1, -1): 
	        if questions[i]['stat']['frontend_question_id'] == pb_num:
	            question = questions[i]
	            self.pb_name = question['stat']['question__title']
	            self.level = self.difficultys[question['difficulty']['level'] - 1]
	            break
	    self.getTagsAndVersion()
	    self.UpdateReadme(pb_num)

	def getTagsAndVersion(self):
		print(''.join(str(i) + " : " + self.file_folder[i] + "\n" for i in range(len(self.file_folder))))
		t = int(input("Input tags (end of -1): "))
		while( t != -1 ):
			self.file_tag += "`" + self.file_folder[t] + "` "
			t = int(input("Input tags (end of -1): "))

		self.version_num = input("Input number of version: ")
		return 


	def UpdateReadme(self, pb_num ):
		solved_pb_list = "| " + str(pb_num) + " | " + self.pb_name + " | `" + self.level + "` " + self.file_tag + " | " + str(self.version_num) + " | "
		print("solved_pb_list is : " + solved_pb_list)
		readme_file = file("./README.md")
		readme_content = readme_file.read()
		readme_file.close()

		lines = readme_content.split('\n')
		cnt = 1
		for line in lines:
			line_integer = re.findall(r"\d+", line)
			if(line_integer != [] and int(line_integer[0]) > pb_num):
				lines.insert(cnt-1, solved_pb_list)
				readme_content = '\n'.join(lines)
				break

			cnt += 1

		column_num , No = self.UpdateMonth(lines)
		month_list = str(No) + ". " + str(pb_num)+ "_" + self.pb_name + ": `" + self.level + "` " + self.file_tag + "`" + str(self.version_num)
		month_list +=  " versions` " if self.version_num > 1 else " version` "
		lines.insert(column_num, month_list)
		readme_content = '\n'.join(lines)

		fp = file("./README.md", 'w')
		fp.write(readme_content)
		fp.close()
		print("insert success~~~")


	def UpdateMonth(self, lines):
		time = datetime.datetime.now()
		flag = 0
		column_num = 0
		ans_column_num = 0
		No = 0
		for line in lines:
			column_num += 1

			if self.month[time.month-1] in line:
				flag = 1

			if No != 0 and "###" in line:
				break

			if flag == 1 and self.level[1:len(self.level)] in line:
				line_integer = re.findall(r"\d+", line)
				if(line_integer != []):
					No = line_integer[0]
					ans_column_num = column_num

		return ans_column_num+1, int(No)+1
		
		# TODO: if not have this month, create it.


problem_num = int(input("Problem No: "))

readme = ReadMe()

readme.getProblemName(problem_num)




















