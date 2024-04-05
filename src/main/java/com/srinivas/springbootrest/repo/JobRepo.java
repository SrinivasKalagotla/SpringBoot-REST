package com.srinivas.springbootrest.repo;

import com.srinivas.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            // Java Developer Job Post
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate")),

            // Frontend Developer Job Post
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    Arrays.asList("HTML", "CSS", "JavaScript", "React")),

            // Data Scientist Job Post
            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    Arrays.asList("Python", "Machine Learning", "Data Analysis")),

            // Network Engineer Job Post
            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    Arrays.asList("Networking", "Cisco", "Routing", "Switching")),

            // Mobile App Developer Job Post
            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    Arrays.asList("iOS Development", "Android Development", "Mobile App")),

            // DevOps Engineer Job Post
            new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines", 4,
                    Arrays.asList("DevOps", "CI/CD", "Docker", "Kubernetes")),

            // UI/UX Designer Job Post
            new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces", 2,
                    Arrays.asList("User Experience", "User Interface Design", "Prototyping")),

            // Cybersecurity Analyst Job Post
            new JobPost(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats", 4,
                    Arrays.asList("Cybersecurity", "Network Security", "Incident Response")),

            // Full Stack Developer Job Post
            new JobPost(9, "Full Stack Developer", "Experience in both front-end and back-end development", 5,
                    Arrays.asList("JavaScript", "Node.js", "React", "Spring", "MongoDB")),

            // Cloud Architect Job Post
            new JobPost(10, "Cloud Architect", "Design and implement cloud infrastructure solutions", 6,
                    Arrays.asList("Cloud Computing", "AWS", "Azure", "Google Cloud"))
    ));


    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
    }

    public JobPost getJob(int postId) {
        for(JobPost job : jobs){
            if(job.getPostId() == postId){
                return job;
            }
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost job : jobs){
            if(job.getPostId() == jobPost.getPostId()){
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostDesc(jobPost.getPostDesc());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int postId) {
        for(JobPost job : jobs){
            if(job.getPostId() == postId){
                jobs.remove(job);
            }
        }
    }
}
