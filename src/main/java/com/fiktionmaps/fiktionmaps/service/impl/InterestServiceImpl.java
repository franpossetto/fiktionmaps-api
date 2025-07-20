package com.fiktionmaps.fiktionmaps.service.impl;

import com.fiktionmaps.fiktionmaps.model.Fiction;
import com.fiktionmaps.fiktionmaps.model.Interest;
import com.fiktionmaps.fiktionmaps.model.User;
import com.fiktionmaps.fiktionmaps.repository.InterestRepository;
import com.fiktionmaps.fiktionmaps.repository.FictionRepository;
import com.fiktionmaps.fiktionmaps.repository.UserRepository;
import com.fiktionmaps.fiktionmaps.service.InterestService;
import com.fiktionmaps.fiktionmaps.service.dto.InterestDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InterestServiceImpl implements InterestService {

    private final InterestRepository interestRepository;
    private final UserRepository userRepository;
    private final FictionRepository fictionRepository;

    public InterestServiceImpl(InterestRepository interestRepository,
                                UserRepository userRepository,
                                FictionRepository fictionRepository) {
        this.interestRepository = interestRepository;
        this.userRepository = userRepository;
        this.fictionRepository = fictionRepository;
    }

    @Override
    public InterestDTO add(Long userId, Long fictionId) {
        // Check if already has interest
        if (interestRepository.existsByUserIdAndFictionId(userId, fictionId)) {
            throw new IllegalStateException("User already has interest in this fiction");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Fiction fiction = fictionRepository.findById(fictionId)
                .orElseThrow(() -> new IllegalArgumentException("Fiction not found"));

        Interest interest = new Interest();
        interest.setUser(user);
        interest.setFiction(fiction);
        interest.setCreatedAt(new Date());

        Interest saved = interestRepository.save(interest);
        return toDTO(saved);
    }

    @Override
    public void remove(Long userId, Long fictionId) {
        Optional<Interest> interest = interestRepository.findByUserIdAndFictionId(userId, fictionId);
        if (interest.isPresent()) {
            interestRepository.delete(interest.get());
        } else {
            throw new IllegalArgumentException("Interest not found");
        }
    }

    @Override
    public List<InterestDTO> findByUser(Long userId) {
        List<Interest> interests = interestRepository.findByUserId(userId);
        return interests.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<InterestDTO> findByFiction(Long fictionId) {
        List<Interest> interests = interestRepository.findByFictionId(fictionId);
        return interests.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Long count(Long fictionId) {
        return interestRepository.countByFictionId(fictionId);
    }

    @Override
    public Long countByUser(Long userId) {
        return interestRepository.countByUserId(userId);
    }

    @Override
    public boolean exists(Long userId, Long fictionId) {
        return interestRepository.existsByUserIdAndFictionId(userId, fictionId);
    }

    private InterestDTO toDTO(Interest interest) {
        return new InterestDTO(
                interest.getId(),
                interest.getUser().getId(),
                interest.getFiction().getId(),
                interest.getCreatedAt()
        );
    }
} 