/************************ SIGNATURES: define types and relationships ************************/
-- Farm: farm in Telegana
sig Farm {}
-- Area:  area in Telegana
sig Area {
	farms: some Farm
}
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
	amout: Float
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
	-- answer
	answer: lone String,
	-- feedback: the score is given to the solution for the problem
	feedback: lone Int,
	-- status: the status of a problem
	status: one ProblemStatus
} {
	feedback >= 0
	-- TBD: A problem is proccessed if and only if a answer is given
	-- A Problem is closed if and only if a feedback is given
	status = Closed <=> feedback > 0
}

-- DialyPlanStatus: the status of a daily plan
abstract sig DailyPlanStatus {}
-- DPOpened: the daily plan is in this status when created or modified
one sig DPOpened extends DailyPlanStatus {}
-- DPClosed: the daily plan is completed when Agronomist confirm and speicify the deviation
one sig DPClosed extends DailyPlanStatus {}

-- Date
sig Date {}
-- Daily Plan
sig DailyPlan {
	date: one Date,
	-- status: the status of a daily plan
	status: one DailyPlanStatus,
	-- farmer: which farmers included in this daily plan
	farmer: set Farmer,
	-- deviation
	deviation: lone String
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

-- User: who use DREAM
abstract sig User{}

-- Farmer: a farmer that uses DREAM
sig Farmer extends User{
	performance: Int,

	own: one Farm,
	-- reports: set of production report
	reports: set Report,
	-- requests: Farmer's problem list
	requests: set Problem
} {
	performance >= 0
	-- performance is positive implies Farmer reports at least one production info
	performance > 0 => #reports > 0
}

-- Agronomist： an agronomist that uses DREAM
sig Agronomist extends User {
	-- area: the area an agronomist is responsible of. Agronomist is reponsible for only one area
	area: one Area,

	dailyplans: set DailyPlan,
	answers: set Problem
}


/************************ FACT: properties of models, constraints! ************************/
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

-- Every Area is associated with one and only one Agronomist
fact areaBelongsToAnAgronomist {
	all a: Area | one ag: Agronomist | ag.area = a
}

-- Every Daily Plan is associated with one and only one Agronomist
fact dailyplanBelongsToAnAgronomist {
	-- no dp: DailyPlan | some ag1, ag2: Agronomist | ag1 != ag2 and dp in ag1.dailyplans and dp in ag2.dailyplans
	all dp: DailyPlan | one ag: Agronomist | dp in ag.dailyplans
}

-- Every Date is associated with one and only one Daily Plan
fact dateAssociatedWithADailyplan {
	all d: Date | one dp: DailyPlan | dp.date = d
}

-- TBD: Every Problem is associated with no more that one Agronomist

--  Agronomist visits each farmer at least twice a year. 

--  Agronomist visits under-performing farmer more often.  


/************************  ASSERTIONS:  properties we want to check ************************/
-- TODO: G8 - If Farmer has a problem and the problem has an answer, 
-- it should be answered by the Agronomist who is responsible for the area 
-- where the Farmer's farm belongs to.

-- TODO: For each agronomist



/************************  Preidications / functions: resusable expressions ************************/
pred show() {}

pred simpleCase {
	#Area=2 and #Agronomist=3
	#DailyPlan=2
	#Farmer=4 and #Report=3
}

/********  COMMANDS:  instruct which assertions to check and how: run predicate, check assertion ********/
run show for 5
--run simpleCase for 6
