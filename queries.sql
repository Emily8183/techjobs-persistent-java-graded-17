-- PART 1

-- PART 2
SELECT name
FROM employer
WHERE location = "St. Louis City";

-- PART 3
DROP TABLE job;

-- PART 4
SELECT *
FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;