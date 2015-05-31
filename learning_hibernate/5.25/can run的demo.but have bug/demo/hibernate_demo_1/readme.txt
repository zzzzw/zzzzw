课程c{cid,cname}
学生s{sid，sname}
课程sc{sid,cid,score}
create table c(
	cid	int(10)	auto_increment	primary key,
	cname	varchar(20)	not null
);
create table s(
	sid	int(10)	auto_increment	primary key,
	sname	varchar(20)	not null
);
create table sc(
	sid	int(10)	references s(sid),
	cid	int(10) references c(cid),
	score double(5,2)	not null
);