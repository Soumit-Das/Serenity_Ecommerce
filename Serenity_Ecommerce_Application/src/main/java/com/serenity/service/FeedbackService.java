package com.serenity.service;

import java.util.List;

import com.serenity.exception.FeedbackException;
import com.serenity.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback) throws FeedbackException;

	public Feedback getFeedbackById(int fid) throws FeedbackException;

	public List<Feedback> getAllFeedback() throws FeedbackException;

	public Feedback updateFeedback(int fid, Feedback feedback) throws FeedbackException;

	public Feedback deleteFeedback(int fid) throws FeedbackException;

}
