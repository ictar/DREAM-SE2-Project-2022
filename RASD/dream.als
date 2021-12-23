/************************ SIGNATURES: define types and relationships ************************/
-- Farm: farm in Telegana
sig Farm {}
-- Area:  area in Telegana
sig Area {
	farms: some Farm
}

-- Float: positive float number
sig Float {
	left: one Int,
	right: one Int
} {
	left >= 0
	right >= 0
}
-- Report: production report
sig Report {
	-- amount: production amount
	amount: Float
}
-- ProblemStatus: the status of a problem
abstract sig ProblemStatus{}
-- Open: the problem is created by a farmer
one sig Opened extends ProblemStatus {}
-- Processing: the problem is answered by a agronomist 
one sig Processing extends ProblemStatus {}
-- Closed: farmer gives the problem a feedback and close it.
one sig Closed extends ProblemStatus {}

-- Problem
sig Problem {
	-- feedback: the score is given to the solution for the problem
	feedback: lone Int,
	-- status: the status of a problem
	status: one ProblemStatus
} {
	feedback >= 0
}

-- Date
sig Date {}
-- Daily Plan
sig DailyPlan {
	date: one Date,

	-- farmer: which farmers included in this daily plan
	farmer: set Farmer
} 

-- Time
sig Time {
	-- ts: timestamp
	ts: Int
} { ts > 0}
-- Comment: 
sig Comment {
	time: one Time
}
sig Post {
	time: one Time,
	comments: set Comment
}
-- Forum: in which Farmer can discuss with each other
one sig Forum {
	posts: set Post
}

-- PhoneNumber: phone number for farmer
sig PhoneNumber {}
-- AgEmail: email for agronomist
sig AgEmail {}
-- PmEmail: email for policymaker
sig PmEmail {}
-- User: who use DREAM
abstract sig User{}

-- Farmer: a farmer that uses DREAM
sig Farmer extends User{
	phonenumber: one PhoneNumber,
	performance: Int,

	own: one Farm,
	-- reports: set of production report
	reports: set Report,
	-- requests: Farmer's problem list
	requests: set Problem
} {
	-- If a Farmer does not report his/her production information, 
	-- his/her performance cannot be identified and be use the default value 0
	#reports = 0 => performance = 0
	-- performance is positive implies Farmer reports at least one production info
	performance > 0 => #reports > 0
}

-- Agronomist： an agronomist that uses DREAM
sig Agronomist extends User {
	email: one AgEmail,
	-- area: the area an agronomist is responsible of. Agronomist is reponsible for only one area
	area: one Area,

	dailyplans: set DailyPlan,
	answers: set Problem
}

-- PolicyMaker: a policy maker that uses DREAM
sig PolicyMaker extends User {
	email: one PmEmail
}

/************************ FACT: properties of models, constraints! ************************/

-- Every phonenumber is associated with one and only one Farmer
fact phonenumberBelongsToAFarmer {
	all pn: PhoneNumber | one f: Farmer | f.phonenumber = pn
}

-- Every policymaker email is associated with one and only one PolicyMaker
fact emailBelongsToAPolicyMaker {
	all pe: PmEmail | one pm: PolicyMaker | pm.email = pe
}

-- Every agronomist email is associated with one and only one Agronomist
fact emailBelongsToAnAgronomist {
	all ae: AgEmail | one a: Agronomist | a.email = ae
}

-- Every Comment is associated with one and only one Post
fact commentBelongsToAPost {
	all c: Comment | one p: Post | c in p.comments
}

-- A Comment cannot be earlier than associated Post
fact noCommenteEarlierThanPost {
	all p: Post | all c: p.comments | c.time.ts > p.time.ts
}

-- Every Report is associated with one and only one Farmer
fact reportBelongsToAFarmer {
	all r: Report | one f: Farmer | r in f.reports
}

--  Every Farm is associated with one and only one Farmer
fact farmBelongsToAFarmer {
	all fm: Farm | one f: Farmer | f.own = fm
}

-- Every farm is associated with one and only one Area
fact farmBelongsToAnArea {
	all fm: Farm | one a: Area | fm in a.farms
}

-- Every Problem is associated with one and only one Farmer
fact problemBelongsToAFarmer {
	all p: Problem | one f: Farmer | p in f.requests
}
-- Every Problem is associated with no more than one Agronomist
fact problemBelongsToAFarmer {
	all p: Problem | lone a: Agronomist | p in a.answers
}

-- Every Area is associated with one and only one Agronomist
fact areaBelongsToAnAgronomist {
	all a: Area | one ag: Agronomist | ag.area = a
}

-- Every Daily Plan is associated with one and only one Agronomist
fact dailyplanBelongsToAnAgronomist {
	all dp: DailyPlan | one ag: Agronomist | dp in ag.dailyplans
}

-- Every Date is associated with one and only one Daily Plan
fact dateAssociatedWithADailyplan {
	all d: Date | one dp: DailyPlan | dp.date = d
}

-- A Farmer's request can only be handled by the Agronomist who is reponsible for the area where is the Farmer's farm in.
fact problemAnswerByResponsibleAgronomist {
	all f: Farmer | all p: f.requests | (p.status in Processing or p.status in Closed)
		implies
			one a: Agronomist | p in a.answers and f.own in a.area.farms
}

-- A problem is processing if and only if it is associated to an agronomist and without feedback
fact processingProblem {
	all p: Problem |
		p.status in Processing
		iff
		all a: Agronomist |
			p in a.answers and p.feedback = 0
}
-- A problem is closed if and only if it is associated to an agronomist and with feedback
fact closedProblem {
	all p: Problem |
		p.status in Closed
		iff
		all a: Agronomist |
			p in a.answers and p.feedback > 0
}
-- A problem is opened if and only if it is not associated to any agronomist and any feedback
fact openedProblem {
	all p: Problem |
		p.status in Opened
		iff
		all a: Agronomist |
			p not in a.answers and p.feedback = 0
} 


-- Agronomist's dailyplans only involve the farmers in he/she reponsible area
fact DPfarmerInAgronomistResponsibleArea {
	all a: Agronomist | all dp: a.dailyplans | #dp.farmer > 0
		implies
			all f: dp.farmer | f.own in a.area.farms
}

/************************  ASSERTIONS:  properties we want to check ************************/
-- Every email uniquely identifies a registered agronomist
assert uniqueAgronomistEmail {
	all disj a1, a2: Agronomist | a1.email != a2.email
}
check uniqueAgronomistEmail for 10

-- Every email uniquely identifies a registered policymaker
assert uniquePolicyMakerEmail {
	all disj pm1, pm2: PolicyMaker | pm1.email != pm2.email
}
check uniquePolicyMakerEmail for 10

-- Every phone number uniquely identifies a registered farmer
assert uniqueFarmerPhoneNumber {
	all disj f1, f2: Farmer | f1.phonenumber != f2.phonenumber
}
check uniqueFarmerPhoneNumber for 10

-- Agronomist only handles request from farmers in his/her responsible area
assert agronomistAnswerResponsibleFarmer {
	all a: Agronomist | all p: a.answers | all f: Farmer | p in f.requests
		implies
			f.own in a.area.farms
}
check agronomistAnswerResponsibleFarmer for 10


/************************  Preidications / functions: resusable expressions ************************/
pred simpleCase {
	#Farmer = 3
	#Agronomist = 2
	#DailyPlan = 2
	#Problem > 2
}

/********  COMMANDS:  instruct which assertions to check and how: run predicate, check assertion ********/
--run show for 6
run simpleCase for 8
