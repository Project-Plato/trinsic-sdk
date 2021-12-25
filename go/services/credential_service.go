package services

import (
	"context"
	"encoding/json"
	sdk "github.com/trinsic-id/sdk/go/proto"
	"google.golang.org/grpc"
)

func CreateCredentialService(profile *sdk.AccountProfile, serverConfig *sdk.ServerConfig, channel *grpc.ClientConn) (CredentialService, error) {
	base, err := CreateServiceBase(profile, serverConfig, channel)
	if err != nil {
		return nil, err
	}
	service := &CredentialBase{
		ServiceBase: base,
		client:      sdk.NewVerifiableCredentialClient(base.channel),
	}

	return service, nil
}

type CredentialService interface {
	Service
	IssueCredential(userContext context.Context, document Document) (Document, error)
	CreateProof(userContext context.Context, documentId string, revealDocument Document) (Document, error)
	VerifyProof(userContext context.Context, proofDocument Document) (bool, error)
	Send(userContext context.Context, document Document, email string) error
}

type CredentialBase struct {
	*ServiceBase
	client sdk.VerifiableCredentialClient
}

func (c *CredentialBase) IssueCredential(userContext context.Context, document Document) (Document, error) {
	jsonBytes, err := json.Marshal(document)
	if err != nil {
		return nil, err
	}
	issueRequest := &sdk.IssueRequest{
		Document: &sdk.JsonPayload{
			Json: &sdk.JsonPayload_JsonString{
				JsonString: string(jsonBytes),
			},
		},
	}

	md, err := c.GetMetadataContext(userContext, issueRequest)
	if err != nil {
		return nil, err
	}
	response, err := c.client.Issue(md, issueRequest)
	if err != nil {
		return nil, err
	}
	var doc map[string]interface{}
	err = json.Unmarshal([]byte(response.Document.GetJsonString()), &doc)
	if err != nil {
		return nil, err
	}
	return doc, nil
}

func (c *CredentialBase) CreateProof(userContext context.Context, documentId string, revealDocument Document) (Document, error) {
	jsonString, err := json.Marshal(revealDocument)
	if err != nil {
		return nil, err
	}
	request := &sdk.CreateProofRequest{
		DocumentId: documentId,
		RevealDocument: &sdk.JsonPayload{
			Json: &sdk.JsonPayload_JsonString{
				JsonString: string(jsonString),
			},
		},
	}
	md, err := c.GetMetadataContext(userContext, request)
	if err != nil {
		return nil, err
	}
	proof, err := c.client.CreateProof(md, request)
	if err != nil {
		return nil, err
	}
	var proofMap map[string]interface{}
	err = json.Unmarshal([]byte(proof.ProofDocument.GetJsonString()), &proofMap)
	if err != nil {
		return nil, err
	}
	return proofMap, nil
}

func (c *CredentialBase) VerifyProof(userContext context.Context, proofDocument Document) (bool, error) {
	jsonString, err := json.Marshal(proofDocument)
	if err != nil {
		return false, err
	}
	request := &sdk.VerifyProofRequest{
		ProofDocument: &sdk.JsonPayload{
			Json: &sdk.JsonPayload_JsonString{
				JsonString: string(jsonString),
			},
		},
	}
	md, err := c.GetMetadataContext(userContext, request)
	if err != nil {
		return false, err
	}
	proof, err := c.client.VerifyProof(md, request)
	if err != nil {
		return false, err
	}
	return proof.Valid, nil
}

func (c *CredentialBase) Send(userContext context.Context, document Document, email string) error {
	jsonString, err := json.Marshal(document)
	if err != nil {
		return err
	}
	request := &sdk.SendRequest{
		DeliveryMethod: &sdk.SendRequest_Email{
			Email: email,
		},
		Document: &sdk.JsonPayload{
			Json: &sdk.JsonPayload_JsonString{
				JsonString: string(jsonString),
			},
		},
	}
	md, err := c.GetMetadataContext(userContext, request)
	if err != nil {
		return err
	}
	_, err = c.client.Send(md, request)
	if err != nil {
		return err
	}
	return nil
}