package main

import "fmt"

// Service defines the common interface for both the real service and the proxy.
// It declares a single method, Request, which takes a user string and returns a response string.
type Service interface {
	Request(user string) string
}

// RealService is the actual object that implements the Service interface.
// It handles the main logic for processing requests.
type RealService struct{}

// Request processes the request for the given user and returns a success message.
func (s *RealService) Request(user string) string {
	return fmt.Sprintf("✅ Access granted to the service for %s", user)
}

// AuthProxy is a proxy that implements the Service interface.
// It acts as an intermediary, verifying user permissions before delegating the request to the real service.
type AuthProxy struct {
	Service            // Embedding the Service interface for delegation
	allowedUser string // The user who is allowed to access the service
}

// Request checks if the user is allowed to access the service.
// If the user is not allowed, it returns an access denied message.
// Otherwise, it delegates the request to the embedded Service.
func (p *AuthProxy) Request(user string) string {
	if user != p.allowedUser {
		return fmt.Sprintf("❌ Access denied for %s", user)
	}
	return p.Service.Request(user)
}

// main is the entry point of the application.
// It initializes the real service and the proxy, and tests the proxy with different users.
func main() {
	// Initialize the real service and the proxy with the allowed user.
	realService := &RealService{}
	proxy := &AuthProxy{Service: realService, allowedUser: "admin"}

	// Test the proxy with different users.
	fmt.Println(proxy.Request("guest")) // ❌ Access denied
	fmt.Println(proxy.Request("admin")) // ✅ Access granted
}

