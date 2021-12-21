/************************ SIGNATURES: define types and relationships ************************/
-- Farm: farm in Telegana
sig Farm {}
-- Area:  area in Telegana
sig Area {
	farms: some Farm
}
sig Float {
	left: one Int
	right: one Int
}
-- Report: production report
sig Report {
	-- amount: production amount
	amout: Float
}

-- ProblemStatus: the status of a problem
abstract sig ProblemStatus{}
-- Open: the problem is created by a farmer
one sig Open extends ProblemStatus {}
-- Processing: agronomist is processing the problem
one sig Processing extends ProblemStatus {}
-- Solving: farmer is solving the problem
one sig Solving extends ProblemStatus {}
-- Close: farmer gives the problem a feedback and close it.
one sig Close extends ProblemStatus {}

-- Problem
sig Problem {
	-- feedback: the score is given to the solution for the problem
	feedback: lone Int
	-- status: the status of a problem
	status: one ProblemStatus
}

-- DialyPlanStatus: the status of a daily plan
abstract sig DailyPlanStatus {}
-- DPOpen: the daily plan is created
one sig DPOpen extends DailyPlanStatus {}
-- Modified: the daily plan is modified
one sig Modified extends DailyPlanStatus {}
-- Executed: the daily plan is executed
one sig Executed extends DailyPlanStatus {}
-- Completed: the daily plan is completed
one sig Completed extends DailyPlanStatus {}

-- Daily Plan
sig DailyPlan {
	-- status: the status of a daily plan
	status: one DialyPlanStatus
	farmer: one Farmer
} 

-- Comment: 
sig Comment {
	
}
sig Post {
	comments: set Comment
}
sig Forum {
	posts: set Post
}

-- User: who use DREAM
abstract sig User{}

-- Farmer: a farmer that uses DREAM
sig Farmer extends User{
	performance: Int

	own: one Farm
	reports: set Report
	problems: set Problem
} {
	performance >= 0
}

-- Agronomist： an agronomist that uses DREAM
sig Agronomist extends User {
	-- area: the area an agronomist is responsible of
	area: one Area

	dailyplans: set DailyPlan
	problems: set Problem
}


/************************ FACT: properties of models, constraints! ************************/
-- Every Comment is associated with one and only one Post
fact commentBelongsToAPost {
	no c: Comment | some p1, p2: Post | p1 != p2 and c in p.comments and c in p.comments
}

-- Every Post is associated with one and only one Forum
fact postBelongsToAForum {
	no p: Post | some f1, f2: Forum | f1 != f2 and p in f1.posts and p in f2.posts
}

-- Every Report is associated with one and only one Farmer
fact reportBelongsToAFarmer {
	no r: Report | some f1, f2: Farmer | f1 != f2 and r in f1.reports and r in f2.reports
}

--  Every Farm is associated with one and only one Farmer
fact farmBelongsToAFarmer {
	no f: Farm | some f1, f2: Farmer | f1 != f2 and f = f1.own and f = f2.own
}

-- Every Problem is associated with one and only one Farmer
fact problemBelongsToAFarmer {
	no p: Problem | some f1, f2: Farmer | f1 != f2 and p in f1.problems and p in f2.problems
}

-- Every Area is associated with one and only one Agronomist
fact areaBelongsToAnAgronomist {
	no a: Area | some ag1, ag2: Agronomist | ag1 != ag2 and a = ag1.area and a = ag2.area
}

-- Every Daily Plan is associated with one and only one Agronomist
fact dailyplanBelongsToAnAgronomist {
	no dp: DailyPlan | some ag1, ag2: Agronomist | ag1 != ag2 and dp in ag1.dailyplans and dp in ag2.dailyplans
}


-- TBD: Every Problem is associated with no more that one Agronomist

--  Agronomist has at least one responsible farm. 

--  Agronomist visits each farm at least twice a year. 

--  Agronomist visits under-performing farm more often.  


/************************  Preidications / functions: resusable expressions ************************/
--
pred addCommentToPost[p, p': Post, c: Comment]
{
	b'.comments = b.comments + c
}

/************************  ASSERTIONS:  properties we want to check ************************/


/********  COMMANDS:  instruct which assertions to check and how: run predicate, check assertion ********/
